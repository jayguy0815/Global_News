package com.jayguy.globalnews.ui.views

/**
 * Created by Leo on 2022/11/8.
 */

import androidx.compose.foundation.BorderStroke
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.jayguy.globalnews.R
import com.jayguy.globalnews.ui.theme.GlobalGameTheme

@Composable
fun ErrorButton(
    modifier: Modifier = Modifier,
    text: String = "",
    onClick: () -> Unit = {},
) {
    ConstraintLayout(
        modifier = modifier
    ) {
        val (
            buttonText,
        ) = createRefs()
        TextButton(
            modifier = Modifier
                .constrainAs(buttonText){
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                },
            border = BorderStroke(
                1.dp,
                Color.Blue,
            ),
            onClick = onClick,
        ){
            Text(text = text)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorButtonPreview() {
    GlobalGameTheme {
        ErrorButton(
            text = stringResource(id = R.string.error)
        )
    }
}