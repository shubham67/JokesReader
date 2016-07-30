package com.project.bittu.jokesreader;

import android.app.Application;
import android.content.Context;
import android.support.v4.util.Pair;
import android.test.ApplicationTestCase;

import org.mockito.Mock;

import java.util.concurrent.TimeUnit;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }
    FetchAsyncTask task;
    String result;
    @Mock
    Context mockContext;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        result = null;
        task = new FetchAsyncTask() {
            @Override
            protected void onPostExecute(String joke) {
                //No need to launch intent, so override this method
            }
        };
    }

    public void testAsyncReturnType() {

        try {

            //Default timeout for the GCM server is 20 seconds
            //If the .get can't get the result in 10 seconds, something is wrong anyway
            //Greater than 20 seconds results in an error string returned and requires further interpretation
            task.execute(new Pair<Context, String>(mockContext, BuildConfig.Type));
            result = task.get(10, TimeUnit.SECONDS);
            assertNotNull(result);

        } catch (Exception e) {
            fail("Timed out");
        }
    }
}