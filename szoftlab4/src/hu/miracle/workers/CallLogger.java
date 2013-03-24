package hu.miracle.workers;

import java.io.PrintStream;

public class CallLogger {

	private static int indent = 4;
	private static String indent_str = " ";
	private static CallLogger logger = null;

	private PrintStream ostream;
	private boolean enabled;
	private int depth;

	public CallLogger(PrintStream ostream) {
		this.ostream = ostream;
		this.depth = 0;
		this.enabled = true;
	}

	public static CallLogger getLogger() {
		if (logger == null) {
			synchronized (CallLogger.class) {
				if (logger == null) {
					logger = new CallLogger(System.out);
				}
			}
		}
		return logger;
	}

	protected String indentation() {
		String indentation = "";
		for (int i = 0; i < depth * indent; i++) {
			indentation += indent_str;
		}
		return indentation;
	}

	public void enable() {
		enabled = true;
	}

	public void disable() {
		enabled = false;
	}

	public void entering(Object obj, String method) {
		if (enabled) {
			String output = indentation();
			if (obj != null) {
				output += String.format("%s<%s>.%s() {", obj.getClass().getCanonicalName(),
						Integer.toHexString(obj.hashCode()), method);
			} else {
				output += String.format("%s() {", method);
			}
			ostream.println(output);
			depth++;
		}
	}

	public void exiting() {
		if (enabled) {
			depth--;
			String output = indentation();
			output += String.format("}");
			ostream.println(output);
		}
	}

	public void finishing() {
		while (depth > 0)
			exiting();
	}
}
