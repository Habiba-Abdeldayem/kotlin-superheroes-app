package com.example.superheroesapp

import SuperheroesTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroesapp.model.Hero
import com.example.superheroesapp.data.HeroesRepository



@Composable
fun HeroList(modifier: Modifier = Modifier, contentPadding: PaddingValues = PaddingValues(20.dp)) {
    val heroes = HeroesRepository.heroes
    LazyColumn(
        contentPadding = contentPadding,
        modifier = modifier
        .padding(horizontal = dimensionResource(id = R.dimen.padding_medium))){
        items(heroes){  hero ->
            HeroCard(hero = hero)
        }
    }
}

@Composable
fun HeroCard(hero: Hero, modifier: Modifier = Modifier){
    Card(
        modifier = modifier
            .padding(bottom = dimensionResource(id = R.dimen.padding_small)),
        elevation = CardDefaults.cardElevation(2.dp)
        ) {
        HeroInfo(hero = hero)
    }

}


@Composable
fun HeroInfo(hero: Hero, modifier: Modifier = Modifier){
    Row (modifier = modifier
        .padding(16.dp)
        .height(72.dp)){
        Column (modifier = Modifier.weight(1f)){
            Text(
                text = stringResource(id = hero.nameRes),
                style = MaterialTheme.typography.displaySmall)
            Text(
                text = stringResource(id = hero.descriptionRes),
                style = MaterialTheme.typography.bodyLarge)
        }
        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_medium)))
        Box(modifier = Modifier
            .height(dimensionResource(id = R.dimen.image_size))){
        Image(
            modifier = Modifier
                .clip(MaterialTheme.shapes.small)
                .size(dimensionResource(id = R.dimen.image_size)),
            painter = painterResource(id = hero.imageRes),
            contentDescription = stringResource(id = hero.nameRes),
            contentScale = ContentScale.Crop)

        }
    }
}

@Preview (showBackground = true)
@Composable
fun  HeeroPreview(){
    SuperheroesTheme {
//        HeroApp()
          HeroList()
//        HeroCard(hero = Hero(R.string.hero4, R.string.description1, R.drawable.android_superhero2))
    }
}