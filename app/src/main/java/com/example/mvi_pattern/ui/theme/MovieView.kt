package com.example.mvi_pattern.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.mvi_pattern.R
import com.example.mvi_pattern.entity.Movie

@Composable
fun MovieView(movie: Movie) {

    ConstraintLayout(
        modifier = Modifier
            .defaultMinSize(minHeight = 300.dp)
            .wrapContentWidth()
            .wrapContentHeight()
            .padding(8.dp)
            .background(Color.Cyan)
    ) {
        // Create references for constraints
        val (statusImage, mainImage, textOverlay) = createRefs()

        // Status Image (Hidden initially)
        Text(modifier = Modifier.constrainAs(statusImage) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                }.background(Color.Green)
                .wrapContentWidth()
                .wrapContentHeight(),
            text = "test",
            fontSize = 30.sp
        )

        // Main Image
        Image(
            painter = painterResource(R.drawable.blue_house),// create a pic downloader for movie.posterPath
            contentDescription = null, // Decorative image
            modifier = Modifier.fillMaxSize()
        )

        // Text Overlay
        Text(
            text = "bottomText", // Replace with dynamic text
            color = Color.Black,
            modifier = Modifier
                .constrainAs(textOverlay) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }.wrapContentWidth()
                .wrapContentHeight(),
            fontSize = 30.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMovieView() {
    MovieView()
}
