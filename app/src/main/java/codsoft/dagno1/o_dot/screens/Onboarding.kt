package codsoft.dagno1.o_dot.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import codsoft.dagno1.o_dot.R
import codsoft.dagno1.o_dot.ui.theme.Gray
import codsoft.dagno1.o_dot.ui.theme.BlueNcs
import codsoft.dagno1.o_dot.ui.theme.Coral
import codsoft.dagno1.o_dot.ui.theme.interFamily
import codsoft.dagno1.o_dot.ui.theme.MainGradient
import codsoft.dagno1.o_dot.ui.theme.TransparentGradient
import codsoft.dagno1.quotelytics.data.OnboardingItem
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Onboarding(navController: NavController) {

    val imageHeight = 250.dp
    val onboardingItems = listOf(
        OnboardingItem(
            R.drawable.task_tracking,
            R.string.onboarding_title0,
            R.string.onboarding_body0
        ),
        OnboardingItem(
            R.drawable.task_mastery,
            R.string.onboarding_title1,
            R.string.onboarding_body1
        ),
        OnboardingItem(
            R.drawable.task_breakdown,
            R.string.onboarding_title2,
            R.string.onboarding_body2
        )
    )


    val pagerState = rememberPagerState(pageCount = {
        3
    })

    // Coroutine scope for handling button clicks
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.weight(0.1f))
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .weight(0.5f)
                .padding(horizontal = 16.dp),
        ) { page ->
            // Our page content
            Column{
                // Display the image
                Image(
                    painter = painterResource(id = onboardingItems[page].imageResId),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(imageHeight)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Display the title
                Text(
                    text = stringResource(id = onboardingItems[page].titleResId),
                    style = TextStyle(
                        fontFamily = interFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        color = BlueNcs
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Display the body text
                Text(
                    text = stringResource(id = onboardingItems[page].bodyResId),
                    style = TextStyle(
                        fontFamily = interFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        color = BlueNcs
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        // Dot indicators for navigation
        Row(
            modifier = Modifier
                .weight(0.1f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(onboardingItems.size) { index ->
                val color =
                    if (pagerState.currentPage == index) MainGradient else TransparentGradient
                Box(
                    modifier = Modifier
                        .padding(5.dp)
                        .height(20.dp)
                        .width(20.dp)
                        .clip(CircleShape)
                        .border(1.dp, Coral, CircleShape)
                        .background(brush = color)
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 100.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(brush = MainGradient)
                .clickable {
                    if (pagerState.currentPage <= 1) {
                        coroutineScope.launch {
                            val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
                            pagerState.animateScrollToPage(nextPage)
                        }
                    } else {
                        navController.navigate(Screen.Signup.route)
                    }
                }
                .padding(vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = if (pagerState.currentPage < 2) "Next" else "Signup",
                style = TextStyle(
                    fontFamily = interFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Gray
                ),
                textAlign = TextAlign.Center,
            )
        }
        Spacer(modifier = Modifier.weight(0.1f))

    }
   
}