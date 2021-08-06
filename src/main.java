import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class PowerShellJavaDemo {

	public static void main(String[] args) throws IOException {

		String line;

		String command = "powershell.exe & \"..\\ps1\\KIM-Check\"";

		Process powerShellProcess = Runtime.getRuntime().exec(command);

		powerShellProcess.getOutputStream().close();

		BufferedReader stdout = new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));
		while ((line = stdout.readLine()) != null) {
			System.out.println("Output: " + line);

		}

		stdout.close();

		BufferedReader stderr = new BufferedReader(new InputStreamReader(powerShellProcess.getErrorStream()));
		while ((line = stderr.readLine()) != null) {
			System.out.println("Output: " + line);
		}
		stderr.close();
	}
}