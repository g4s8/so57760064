This is a fork of https://github.com/jetty-project/embedded-jetty-live-war

to demonstrate the bug https://stackoverflow.com/q/57760064/1723695


To reproduce the bug:
 1. Create Okta developer account at https://developer.okta.com/
 2. Create new API token at the dashboard
 3. Put Okta URL and API token to constants `ORG_URL` and `TOKEN` in `TimeServlet`
 4. Build the project with `mvn package`
 5. Run with `java -jar ./livewar-assembly/target/livewar-assembly-1-SNAPSHOT.war`
 6. Open http://localhost:8080/ in the browser
 7. See Jetty logs for error
