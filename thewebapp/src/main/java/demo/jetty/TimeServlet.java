package demo.jetty;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.okta.sdk.authc.credentials.TokenClientCredentials;
import com.okta.sdk.client.Clients;

@SuppressWarnings("serial")
@WebServlet("/time/")
public class TimeServlet extends HttpServlet
{
    
    private final String ORG_URL = "";
    private static final String TOKEN = "";
    
    private static final TimeZone TZ = TimeZone.getDefault();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        // Okta client builder
        Clients.builder()
            .setOrgUrl(ORG_URL)
            .setClientCredentials(new TokenClientCredentials(TOKEN))
            .build();

        // origin code
        Locale locale = req.getLocale();
        Calendar cal = Calendar.getInstance(TZ,locale);
        String dateStr = DateFormat.getDateInstance(DateFormat.DEFAULT,locale).format(cal.getTime());
        String timeStr = DateFormat.getTimeInstance(DateFormat.DEFAULT,locale).format(cal.getTime());
        String tzStr = TZ.getDisplayName(false,TimeZone.SHORT,locale);
        resp.getWriter().println(String.format("%s %s %s",dateStr,timeStr,tzStr));
    }
}
