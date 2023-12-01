package miro.shen.research.mvptddsample

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class RegisterUITest {

    @Rule
    @JvmField
    val activityScenarioRule = ActivityScenarioRule(RegisterActivity::class.java)

    //輸入錯誤的帳號格式
    @Test
    fun wrongLoginIdFormat_should_alert() {

        //輸入正確的帳號
        Espresso.onView(ViewMatchers.withId(R.id.loginId))
            .perform(ViewActions.typeText("1111"), ViewActions.closeSoftKeyboard())

        //輸入錯誤格式的密碼
        Espresso.onView(ViewMatchers.withId(R.id.password))
            .perform(ViewActions.typeText("A112352626"), ViewActions.closeSoftKeyboard())

        //點選註冊按鈕
        Espresso.onView(ViewMatchers.withId(R.id.send))
            .perform(ViewActions.click())

        //註冊失敗，Alert
        Espresso.onView(ViewMatchers.withText("錯誤"))
            .inRoot(RootMatchers.isDialog())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }

    @Test
    fun wrongPassWordFormat_should_alert() {

        //輸入正確的帳號
        Espresso.onView(ViewMatchers.withId(R.id.loginId))
            .perform(ViewActions.typeText("A122234525"), ViewActions.closeSoftKeyboard())

        //輸入錯誤格式的密碼
        Espresso.onView(ViewMatchers.withId(R.id.password))
            .perform(ViewActions.typeText("1234"), ViewActions.closeSoftKeyboard())

        //點選註冊按鈕
        Espresso.onView(ViewMatchers.withId(R.id.send))
            .perform(ViewActions.click())

        //註冊失敗，Alert
        Espresso.onView(ViewMatchers.withText("錯誤"))
            .inRoot(RootMatchers.isDialog())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }

}