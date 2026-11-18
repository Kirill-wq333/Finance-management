package com.example.financemanagement.ui.presentation.feature.shared.avatar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.financemanagement.R
import com.example.financemanagement.ui.theme.FinanceManagementTheme

@Preview
@Composable
private fun PreviewAvatar() {
    FinanceManagementTheme() {
        Avatar(
            avatar = "https://avatars.mds.yandex.net/i?id=7db01608fd0462627e7f189c797fcaaf_l-6431583-images-thumbs&n=13",
            editAvatar = {}
        )
    }
}

@Composable
fun Avatar(
    modifier: Modifier = Modifier,
    avatar: String,
    createAvatar: Boolean = false,
    editAvatar: () -> Unit
) {
    if (createAvatar){
        CreateAvatar(
            avatar = avatar,
            modifier = modifier,
            editAvatar = editAvatar
        )
    } else {
        AvatarItem(avatar = avatar)
    }
}

@Composable
fun CreateAvatar(
    modifier: Modifier = Modifier,
    avatar: String,
    editAvatar: () -> Unit
) {
    AvatarItem(
        avatar = avatar,
        content = {
            Box(
                modifier = Modifier
                    .padding(end = 13.dp)
                    .background(
                        color = colorScheme.primary,
                        shape = CircleShape
                    )
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_camera),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable(onClick = editAvatar)
                        .padding(
                            top = 6.43.dp,
                            end = 5.71.dp,
                            bottom = 7.14.dp,
                            start = 5.71.dp
                        )
                        .size(13.57.dp, 11.43.dp)
                )
            }
        }
    )
}

@Composable
fun AvatarItem(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit = {},
    avatar: String
) {
    Box(
        modifier = modifier
            .size(117.dp)
    ) {
        Box(
            modifier = modifier
                .clip(shape = CircleShape),
        ) {
            AsyncImage(
                model = avatar,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomEnd
        ) {
            content()
        }
    }
}

