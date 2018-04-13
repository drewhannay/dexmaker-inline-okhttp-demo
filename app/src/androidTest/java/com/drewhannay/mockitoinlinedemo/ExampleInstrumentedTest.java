package com.drewhannay.mockitoinlinedemo;

import android.content.Context;
import android.support.test.runner.AndroidJUnit4;
import okhttp3.HttpUrl;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Test
    public void canMockFinals() throws Exception {
        HttpUrl mockUrl = mock(HttpUrl.class);
        Context mockContext = mock(Context.class);
        when(mockContext.getString(R.string.app_name)).thenReturn("Testing");

        AppNameGetter target = new AppNameGetter();

        assertThat(target.appName(mockContext), is("Testing"));
    }

    public static final class AppNameGetter {

        public final String appName(Context context) {
            return context.getString(R.string.app_name);
        }
    }
}
