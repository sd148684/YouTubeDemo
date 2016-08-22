package com.examples.youtubeapidemo.play;

import android.os.SystemClock;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.util.Log;

import com.examples.youtubeapidemo.YouTubeAPIDemoActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * for YouTubePlayerView testing
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class PlayerViewTest {

    @Rule
    public ActivityTestRule<YouTubeAPIDemoActivity> mActivityTestRule =
            new ActivityTestRule<YouTubeAPIDemoActivity>(YouTubeAPIDemoActivity.class);


    @Test
    public void testYouTubeMemoryLeaks() {
        int count = 0;
        while(count < 100) {
            onView(withText("Simple PlayerView")).perform(click());
            SystemClock.sleep(5000L); // waiting for video start playing
            pressBack();
            count++;
            Log.i("PlayerViewTest", "count: " + count);
        }
    }
}
