package miro.shen.research.mvptddsample

import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
//import miro.shen.research.mvptddsample.presenter.Idling
import miro.shen.research.mvptddsample.view.RegisterActivity
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
            .perform(typeText("1111"), closeSoftKeyboard())

        //輸入錯誤格式的密碼
        Espresso.onView(ViewMatchers.withId(R.id.password))
            .perform(typeText("A112352626"), closeSoftKeyboard())

        //點選註冊按鈕
        Espresso.onView(ViewMatchers.withId(R.id.send))
            .perform(click())

        //註冊失敗，Alert
        Espresso.onView(ViewMatchers.withText("錯誤"))
            .inRoot(RootMatchers.isDialog())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }

    @Test
    fun wrongPassWordFormat_should_alert() {

        //輸入正確的帳號
        Espresso.onView(ViewMatchers.withId(R.id.loginId))
            .perform(typeText("A122234525"), closeSoftKeyboard())

        //輸入錯誤格式的密碼
        Espresso.onView(ViewMatchers.withId(R.id.password))
            .perform(typeText("1234"), closeSoftKeyboard())

        //點選註冊按鈕
        Espresso.onView(ViewMatchers.withId(R.id.send))
            .perform(click())

        //註冊失敗，Alert
        Espresso.onView(ViewMatchers.withText("錯誤"))
            .inRoot(RootMatchers.isDialog())
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }

    @Test
    fun register_success_should_satrtActivity() {
//        IdlingRegistry.getInstance().register(Idling.idlingResource)

        //輸入正確的帳號
        Espresso.onView(ViewMatchers.withId(R.id.loginId))
            .perform(typeText("a123456789"), closeSoftKeyboard())

        //輸入正確的密碼
        Espresso.onView(ViewMatchers.withId(R.id.password))
            .perform(typeText("a111111111"), closeSoftKeyboard())

        //點選註冊按鈕
        Espresso.onView(ViewMatchers.withId(R.id.send))
            .perform(click())

        Thread.sleep(3000)

        //註冊成功，導至成功頁。
        Espresso.onView(ViewMatchers.withText("註冊成功"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

//        IdlingRegistry.getInstance().unregister(Idling.idlingResource)
    }

    @Test
    fun wrongPassword_should_alert() {

        //輸入正確的帳號
        Espresso.onView(ViewMatchers.withId(R.id.loginId))
            .perform(ViewActions.typeText("EvanChen"), ViewActions.closeSoftKeyboard())

        //輸入正確的密碼
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