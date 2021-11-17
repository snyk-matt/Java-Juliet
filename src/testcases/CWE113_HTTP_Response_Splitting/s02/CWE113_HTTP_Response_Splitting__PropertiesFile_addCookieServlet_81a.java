/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE113_HTTP_Response_Splitting__PropertiesFile_addCookieServlet_81a.java
Label Definition File: CWE113_HTTP_Response_Splitting.label.xml
Template File: sources-sinks-81a.tmpl.java
*/
/*
 * @description
 * CWE: 113 HTTP Response Splitting
 * BadSource: PropertiesFile Read data from a .properties file (in property named data)
 * GoodSource: A hardcoded string
 * Sinks: addCookieServlet
 *    GoodSink: URLEncode input
 *    BadSink : querystring to addCookie()
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE113_HTTP_Response_Splitting.s02;
import testcasesupport.*;

import javax.servlet.http.*;

import java.util.Properties;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.logging.Level;

public class CWE113_HTTP_Response_Splitting__PropertiesFile_addCookieServlet_81a extends AbstractTestCaseServlet
{
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        data = ""; /* Initialize data */

        /* retrieve the property */
        {
            Properties properties = new Properties();
            FileInputStream streamFileInput = null;

            try
            {
                streamFileInput = new FileInputStream("../common/config.properties");
                properties.load(streamFileInput);

                /* POTENTIAL FLAW: Read data from a .properties file */
                data = properties.getProperty("data");
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
            }
            finally
            {
                /* Close stream reading object */
                try
                {
                    if (streamFileInput != null)
                    {
                        streamFileInput.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing FileInputStream", exceptIO);
                }
            }
        }

        CWE113_HTTP_Response_Splitting__PropertiesFile_addCookieServlet_81_base baseObject = new CWE113_HTTP_Response_Splitting__PropertiesFile_addCookieServlet_81_bad();
        baseObject.action(data , request, response);
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
        goodB2G(request, response);
    }

    /* goodG2B() - use GoodSource and BadSink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        /* FIX: Use a hardcoded string */
        data = "foo";

        CWE113_HTTP_Response_Splitting__PropertiesFile_addCookieServlet_81_base baseObject = new CWE113_HTTP_Response_Splitting__PropertiesFile_addCookieServlet_81_goodG2B();
        baseObject.action(data , request, response);
    }

    /* goodB2G() - use BadSource and GoodSink */
    private void goodB2G(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        data = ""; /* Initialize data */

        /* retrieve the property */
        {
            Properties properties = new Properties();
            FileInputStream streamFileInput = null;

            try
            {
                streamFileInput = new FileInputStream("../common/config.properties");
                properties.load(streamFileInput);

                /* POTENTIAL FLAW: Read data from a .properties file */
                data = properties.getProperty("data");
            }
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
            }
            finally
            {
                /* Close stream reading object */
                try
                {
                    if (streamFileInput != null)
                    {
                        streamFileInput.close();
                    }
                }
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing FileInputStream", exceptIO);
                }
            }
        }

        CWE113_HTTP_Response_Splitting__PropertiesFile_addCookieServlet_81_base baseObject = new CWE113_HTTP_Response_Splitting__PropertiesFile_addCookieServlet_81_goodB2G();
        baseObject.action(data , request, response);
    }

    /* Below is the main(). It is only used when building this testcase on
     * its own for testing or for building a binary to use in testing binary
     * analysis tools. It is not used when compiling all the testcases as one
     * application, which is how source code analysis tools are tested.
     */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}
