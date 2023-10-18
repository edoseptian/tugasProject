package com.example.a235411089_edoseptianponconugroho

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a235411089_edoseptianponconugroho.ui.theme._235411089_EdoSeptianPoncoNugrohoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _235411089_EdoSeptianPoncoNugrohoTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    TipTimeLayout()
                }
            }
        }
    }
}

@Composable
fun TipTimeLayout() {
    // Variables for image, name, creator, and year
    var currentImageIndex by remember { mutableStateOf(0) }

    val images = listOf(
        ImageInfo("Whistler's Mother", "James McNeill Whistler","1871", R.drawable.image1),
        ImageInfo("Self-Portrait with Cropped Hair","Frida Kahlo", "1940", R.drawable.image2),
        ImageInfo("Wanderer above the Sea of Fog", "Caspar David Friedrich","1818", R.drawable.image3)
    )

    val imageInfo = images[currentImageIndex]

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Name:Edo Septian Ponco Nugroho | NIM:235411089")
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = imageInfo.imageResId),
            contentDescription = null, // Add content description here
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()

        )

        Spacer(modifier = Modifier.height(16.dp))

        // Bagian 2: Nama gambar, pembuat gambar, dan tahun gambar
        Text(text = "Name: ${imageInfo.name}")
        Text(text = "Creator: ${imageInfo.creator} | Year: ${imageInfo.year}")


        Spacer(modifier = Modifier.height(16.dp))

        // Bagian 3: Tombol Next dan Previous
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    currentImageIndex = (currentImageIndex - 1 + images.size) % images.size
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Previous")
            }

            Spacer(modifier = Modifier.width(10.dp))

            Button(
                onClick = {
                    currentImageIndex = (currentImageIndex + 1) % images.size
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Next")
            }
        }
    }
}

data class ImageInfo(val name: String, val creator: String, val year: String, val imageResId: Int)

@Preview(showBackground = true)
@Composable
fun TipTimeLayoutPreview() {
    _235411089_EdoSeptianPoncoNugrohoTheme {
        TipTimeLayout()
    }
}