package com.example.messfood.views.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.messfood.navigation.Screen
import com.example.messfood.views.components.CardButton
import com.example.messfood.views.components.PasswordDialog

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoreMenu(navController: NavController) {

    var activeDialog by remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = {
                                navController.navigate(Screen.HomeScreen.route)
                            },
                            modifier = Modifier.size(32.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Navigate Back",
                                modifier = Modifier.size(32.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "More About",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(it)
        ) {
            item {
                CardButton(
                    text = "About Developer",
                    icon = Icons.Default.AccountCircle,
                    onClick = { navController.navigate(Screen.DevScreen.route) }
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                CardButton(
                    text = "Full Week View",
                    icon = Icons.Default.DateRange,
                    onClick = { navController.navigate(Screen.FullWeekScreen.route) }
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                CardButton(
                    text = "Update Menu",
                    icon = Icons.Default.Build,
                    onClick = { activeDialog = "UpdateMenu" }
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                CardButton(
                    text = "Reset Menu",
                    icon = Icons.Default.Refresh,
                    onClick = { activeDialog = "ResetMenu" }
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }

        when (activeDialog) {
            "UpdateMenu" -> {
                PasswordDialog(
                    onDismiss = { activeDialog = null },
                    onSuccess = {
                        activeDialog = null
                        navController.navigate(Screen.UpdateScreen.route)
                    }
                )
            }
            "ResetMenu" -> {
                PasswordDialog(
                    onDismiss = { activeDialog = null },
                    onSuccess = {
                        activeDialog = null
                        navController.navigate(Screen.DevScreen.route)
                    }
                )
            }
        }
    }
}

