package com.example.accessibilityguide
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.filled.TipsAndUpdates
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.accessibilityguide.model.*
import com.example.accessibilityguide.viewmodel.AccessibilityViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                AppNav()
            }
        }
    }
}

@Composable
fun AppNav() {
    val nav = rememberNavController()
    val viewModel: AccessibilityViewModel = viewModel()
    NavHost(navController = nav, startDestination = "welcome") {
        composable("welcome") { WelcomeScreen(nav) }
        composable("about") { AboutScreen(nav) }
        composable("vision") { VisionInputScreen(nav, viewModel) }
        composable("usage") { UsageScreen(nav, viewModel) }
        composable("features") { FeatureScreen(nav, viewModel) }
        composable("report") { ReportScreen(nav,viewModel) }
    }
}
@Composable
fun WelcomeScreen(nav: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF4F46E5),
                        Color(0xFF06B6D4)
                    )
                )
            )
            .padding(24.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Spacer(modifier = Modifier.height(40.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .size(104.dp)
                        .background(
                            color = Color.White.copy(alpha = 0.18f),
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Visibility,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(50.dp)
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "VisionEase",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Personalized visual comfort\nmade just for you",
                    fontSize = 16.sp,
                    color = Color.White.copy(alpha = 0.9f),
                    textAlign = TextAlign.Center,
                    lineHeight = 22.sp
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { nav.navigate("about") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(22.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    )
                ) {
                    Text(
                        text = "Get Started",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF4F46E5)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Built with accessibility in mind",
                    fontSize = 13.sp,
                    color = Color.White.copy(alpha = 0.75f),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}
@Composable
fun AboutScreen(nav: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF4F46E5),
                        Color(0xFF06B6D4)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "How this app helps you",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                lineHeight=32.sp,
            )

            Spacer(Modifier.height(24.dp))

            InfoCard(
                icon = Icons.Default.Visibility,
                text = "Reduces eye strain"
            )

            InfoCard(
                icon = Icons.Default.MenuBook,
                text = "Improves reading comfort"
            )

            InfoCard(
                icon = Icons.Default.Tune,
                text = "Personalized accessibility tips"
            )

            Spacer(Modifier.weight(1f))

            Button(
                onClick = { nav.navigate("vision") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                )
            ) {
                Text(
                    "Continue",
                    color = Color(0xFF4F46E5),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
@Composable
fun InfoCard(icon: ImageVector, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 18.dp, horizontal = 20.dp)
            .background(
                Color.White.copy(alpha = 0.15f),
                RoundedCornerShape(16.dp)
            )
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, contentDescription = null, tint = Color.White, modifier =Modifier.size(24.dp))
        Spacer(Modifier.width(14.dp))
        Text(
            text = text,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            lineHeight=24.sp
        )
    }
}

@Composable
fun AboutItem(text: String, icon: androidx.compose.ui.graphics.vector.ImageVector) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
        shape = RoundedCornerShape(14.dp)
    ) {
        Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, null)
            Spacer(Modifier.width(12.dp))
            Text(text)
        }
    }
}
@Composable
fun VisionInputScreen(
    nav: NavController,
    viewModel: AccessibilityViewModel
) {
    var vision by remember { mutableStateOf("normal") }
    var strain by remember { mutableStateOf("medium") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF312E81),
                        Color(0xFF0891B2)
                    )
                )
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .background(
                    color = Color.White.copy(alpha = 0.95f),
                    shape = RoundedCornerShape(30.dp)
                )
                .padding(24.dp)
        ) {


            Text(
                text = "Vision & Comfort",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1E293B)
            )

            Text(
                text = "Tell us how your eyes feel",
                fontSize = 14.sp,
                color = Color(0xFF64748B)
            )

            Spacer(Modifier.height(28.dp))


            SectionHeader(icon = Icons.Default.Visibility, title = "Vision Type")

            OptionPill("Normal", vision) { vision = it }
            OptionPill("Positive", vision) { vision = it }
            OptionPill("Negative", vision) { vision = it }

            Spacer(Modifier.height(28.dp))


            SectionHeader(icon = Icons.Default.RemoveRedEye, title = "Eye Strain Level")

            OptionPill("Low", strain) { strain = it }
            OptionPill("Medium", strain) { strain = it }
            OptionPill("High", strain) { strain = it }

            Spacer(Modifier.weight(1f))


            Button(
                onClick = {
                    viewModel.visionType = vision.lowercase()
                    viewModel.eyeStrain = strain.lowercase()
                    nav.navigate("usage")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp),
                shape = RoundedCornerShape(22.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4F46E5)
                ),
                elevation = ButtonDefaults.buttonElevation(8.dp)
            ) {
                Text(
                    "Continue",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}
@Composable
fun SectionHeader(icon: ImageVector, title: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(bottom = 12.dp)
    ) {
        Box(
            modifier = Modifier
                .size(36.dp)
                .background(
                    Color(0xFFEEF2FF),
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(icon, contentDescription = null, tint = Color(0xFF4F46E5))
        }

        Spacer(Modifier.width(12.dp))

        Text(
            text = title,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1E293B)
        )
    }
}
@Composable
fun OptionPill(
    label: String,
    selected: String,
    onSelect: (String) -> Unit
) {
    val isSelected = selected == label.lowercase()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .background(
                if (isSelected) Color(0xFF4F46E5) else Color(0xFFF1F5F9),
                RoundedCornerShape(16.dp)
            )
            .clickable { onSelect(label.lowercase()) }
            .padding(vertical = 14.dp, horizontal = 16.dp)
    ) {
        Text(
            text = label,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = if (isSelected) Color.White else Color(0xFF334155)
        )
    }
}

@Composable
fun VisionOption(options: List<String>, selected: String, onSelect: (String) -> Unit) {
    options.forEach {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp)
                .clickable { onSelect(it) },
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(selected = selected == it, onClick = { onSelect(it) })
            Text(it)
        }
    }
}
@Composable
fun UsageScreen(
    nav: NavController,
    viewModel: AccessibilityViewModel
) {
    val options = listOf("Reading", "Browsing", "Night Use", "Study / Work")
    val selected = remember { mutableStateListOf<String>() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF4F46E5),
                        Color(0xFF06B6D4)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {

            Spacer(Modifier.height(12.dp))


            Text(
                text = "Usage Preference",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Text(
                text = "How do you mostly use your device?",
                fontSize = 15.sp,
                color = Color.White.copy(alpha = 0.9f)
            )

            Spacer(Modifier.height(32.dp))


            options.forEach { option ->
                UsageChip(
                    text = option,
                    selected = selected.contains(option)
                ) {
                    if (selected.contains(option)) {
                        selected.remove(option)
                    } else {
                        selected.add(option)
                    }
                }
                Spacer(Modifier.height(14.dp))
            }

            Spacer(Modifier.weight(1f))


            Button(
                onClick = {
                    viewModel.usage = selected.map {
                        it.lowercase().replace(" ", "_")
                    }
                    nav.navigate("features")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                )
            ) {
                Text(
                    text = "Next",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF4F46E5)
                )
            }
        }
    }
}
@Composable
fun UsageChip(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(
                if (selected)
                    Color.White
                else
                    Color.White.copy(alpha = 0.25f)
            )
            .border(
                width = if (selected) 0.dp else 1.dp,
                color = Color.White.copy(alpha = 0.5f),
                shape = RoundedCornerShape(14.dp)
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 17.sp,
            fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium,
            color = if (selected)
                Color(0xFF4F46E5)
            else
                Color.White
        )
    }
}
@Composable
fun FeatureScreen(
    nav: NavController,
    viewModel: AccessibilityViewModel
) {

    val features = listOf(
        "Text Size" to "text_size",
        "Line Spacing" to "line_spacing",
        "Contrast" to "contrast",
        "Dark Mode" to "dark_mode",
        "Image Clarity" to "image_clarity"
    )

    val selected = remember { mutableStateListOf<Pair<String, String>>() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF4F46E5),
                        Color(0xFF06B6D4)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {


            Text(
                text = "Accessibility Features",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Text(
                text = "Choose what matters most to you",
                fontSize = 15.sp,
                color = Color.White.copy(0.9f)
            )

            Spacer(Modifier.height(20.dp))


            features.forEach { item ->
                val isChecked = selected.contains(item)

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clickable {
                            if (isChecked) selected.remove(item)
                            else selected.add(item)
                        },
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White.copy(alpha = 0.15f)
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(18.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = item.first,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White,
                            modifier = Modifier.weight(1f)
                        )

                        Checkbox(
                            checked = isChecked,
                            onCheckedChange = {
                                if (isChecked) selected.remove(item)
                                else selected.add(item)
                            },
                            colors = CheckboxDefaults.colors(
                                checkedColor = Color.White,
                                uncheckedColor = Color.White,
                                checkmarkColor = Color(0xFF4F46E5)
                            )
                        )
                    }
                }
            }

            Spacer(Modifier.weight(1f))


            Button(
                onClick = {
                    viewModel.features = selected.map { it.second }
                    viewModel.analyze()
                    nav.navigate("report")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                )
            ) {
                Text(
                    "Generate Report",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF4F46E5)
                )
            }
        }
    }
}
@Composable
fun ReportScreen(
    nav: NavController,
    viewModel: AccessibilityViewModel
) {

    val response = viewModel.response

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFF8FAFC),
                        Color(0xFFE0F2FE)
                    )
                )
            )
    ) {

        if (response == null) {


            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator(color = Color(0xFF2563EB))
                Spacer(Modifier.height(16.dp))
                Text(
                    "Analyzing your preferences…",
                    fontSize = 18.sp,
                    color = Color.DarkGray
                )
            }

        } else {

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(
                    start = 20.dp,
                    end = 20.dp,
                    top = 20.dp,
                    bottom = 140.dp
                )
            ) {


                item {
                    Text(
                        "Your Accessibility Report",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1E3A8A)
                    )

                    Spacer(Modifier.height(6.dp))

                    Text(
                        "Personalized recommendations to reduce eye strain",
                        fontSize = 16.sp,
                        color = Color(0xFF475569)
                    )

                    Spacer(Modifier.height(24.dp))
                }
                items(response.recommendations) { rec ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        shape = RoundedCornerShape(20.dp),
                        elevation = CardDefaults.cardElevation(6.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        )
                    ) {
                        Column(
                            modifier = Modifier.padding(18.dp)
                        ) {

                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.TipsAndUpdates,
                                    contentDescription = null,
                                    tint = Color(0xFF2563EB)
                                )

                                Spacer(Modifier.width(8.dp))

                                Text(
                                    rec.title,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF0F172A)
                                )
                            }

                            Spacer(Modifier.height(10.dp))

                            Text(
                                rec.description,
                                fontSize = 16.sp,
                                color = Color(0xFF334155),
                                lineHeight = 22.sp
                            )

                            Spacer(Modifier.height(10.dp))

                            Text(
                                "Why this helps:",
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFF475569)
                            )

                            Text(
                                rec.reason,
                                fontSize = 14.sp,
                                color = Color(0xFF64748B)
                            )
                        }
                    }
                }
                item {

                    Spacer(Modifier.height(32.dp))

                    Text(
                        "✨ These suggestions are designed for comfort, not medical advice.",
                        fontSize = 14.sp,
                        color = Color(0xFF64748B)
                    )

                    Spacer(Modifier.height(24.dp))

                    Button(
                        onClick = {
                            nav.navigate("welcome") {
                                popUpTo("welcome") { inclusive = true }
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(54.dp),
                        shape = RoundedCornerShape(18.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF2563EB)
                        )
                    ) {
                        Icon(
                            Icons.Default.Home,
                            contentDescription = null,
                            tint = Color.White
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            "Back to Home",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}