package com.newplay.jumpy.ui.privacy

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrivacyScreen(onBack: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF4DB6AC), // Teal
                        Color(0xFF00796B)  // Dark Teal
                    )
                )
            )
    ) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text("PRIVACY POLICY", fontWeight = FontWeight.ExtraBold, color = Color.White) },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.White
                            )
                        }
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color.Transparent
                    )
                )
            },
            containerColor = Color.Transparent
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(24.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Your Privacy Matters",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White
                )

                PrivacyDetailSection(
                    title = "1. Data Collection",
                    content = "Jumpy Game is built with a 'Privacy First' approach. We do not collect, store, or share any personal identifiable information (PII) from our users."
                )

                PrivacyDetailSection(
                    title = "2. Local Storage Usage",
                    content = "The application uses local storage on your device (SharedPreferences) solely to save your personal high scores. This data never leaves your device."
                )

                PrivacyDetailSection(
                    title = "3. Internet & Future Ads",
                    content = "While the current version of the game works entirely offline, future updates may include internet-based features such as advertisements or global leaderboards. If implemented, we will update this policy accordingly."
                )

                PrivacyDetailSection(
                    title = "4. User Data Safety",
                    content = "Since no data is collected on our servers, there is no risk of your personal information being compromised through our application."
                )

                PrivacyDetailSection(
                    title = "5. Contact & Support",
                    content = "If you have any questions regarding this Privacy Policy or the game, you can contact us at support@jumpygame.com."
                )

                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}

@Composable
fun PrivacyDetailSection(title: String, content: String) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(
            text = content,
            fontSize = 15.sp,
            color = Color.White.copy(alpha = 0.85f),
            lineHeight = 22.sp
        )
    }
}
