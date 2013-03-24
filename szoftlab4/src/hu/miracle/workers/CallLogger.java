package hu.miracle.workers;

import java.io.PrintStream;

public class CallLogger {

	private static int indent = 4;
	private static String indent_str = " ";
	private static CallLogger logger = null;

	private PrintStream ostream;
	private boolean enabled;
	private boolean entered;
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
			if (depth > 0 && entered) {
				depth--;
				ostream.println(indentation() + "{");
				depth++;
			}
			String output = indentation();
			if (obj != null) {
				output += String.format("%s<%s>.%s()", obj.getClass().getSimpleName(),
						Integer.toHexString(obj.hashCode()), method);
			} else {
				output += String.format("%s()", method);
			}
			ostream.println(output);
			depth++;
			entered = true;
		}
	}

	public void exiting() {
		if (enabled) {
			depth--;
			if (!entered) {
				String output = indentation();
				output += "}";
				ostream.println(output);
			} else {
				entered = false;
			}
		}
	}

	public void finishing() {
		boolean tmp = enabled;
		enable();
		while (depth > 0) {
			exiting();
		}
		if (!tmp)
			disable();
	}
}
