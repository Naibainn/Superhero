package com.example.superhero

import android.widget.Space
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superhero.model.Hero
import com.example.superhero.model.HeroesRepository

@Composable
fun HeroesCard(
    hero: Hero,
    modifier: Modifier = Modifier
){
    Card (
        modifier = Modifier
            .clip(MaterialTheme.shapes.medium)
    ) {
        Row (modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_small))){
            HeroInfo(heroName = hero.nameRes, heroDes = hero.descriptionRes, modifier = Modifier.weight(1f))
            HeroImage(heroImage = hero.imageRes)
        }
    }
}

@Composable
fun HeroInfo(
    @StringRes heroName: Int,
    @StringRes heroDes: Int,
    modifier: Modifier = Modifier
){
    Column (modifier
        .padding(end = dimensionResource(id = R.dimen.padding_small))
        .height(72.dp)){
        Text(
            text = stringResource(heroName),
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = stringResource(heroDes),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun HeroImage(
    @DrawableRes heroImage: Int,
    modifier: Modifier = Modifier
){
    Image(
        painter = painterResource(heroImage),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(dimensionResource(R.dimen.image_size))
            .clip(shape = MaterialTheme.shapes.small))
}

@Preview
@Composable
private fun HeroesCardPreview(){
    HeroesCard(hero = HeroesRepository.heroes[0], modifier = Modifier
        .fillMaxSize())
}