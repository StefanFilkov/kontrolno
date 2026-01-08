package com.example.myapplication
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                PizzaOrdersScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PizzaOrdersScreen() {
    val scope = rememberCoroutineScope()

    // Start with 6 pre-created orders
    var orders by remember {
        mutableStateOf(
            FakePizzas.pizzas.take(6).mapIndexed { idx, pizza ->
                PizzaOrder(id = idx.toLong(), pizza = pizza)
            }
        )
    }

    var isAdding by remember { mutableStateOf(false) }
    var nextId by remember { mutableStateOf(orders.size.toLong()) }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Pizza Orders") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Button(
                onClick = {
                    if (isAdding) return@Button
                    isAdding = true

                    scope.launch {
                        delay(500) // simulate adding takes 500ms
                        val randomPizza = FakePizzas.pizzas[Random.nextInt(FakePizzas.pizzas.size)]
                        orders = orders + PizzaOrder(id = nextId++, pizza = randomPizza)
                        isAdding = false
                    }
                },
                enabled = !isAdding,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(if (isAdding) "Adding..." else "Add random order")
            }

            Text(
                text = "Orders: ${orders.size}",
                style = MaterialTheme.typography.titleMedium
            )

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(orders, key = { it.id }) { order ->
                    OrderCard(order)
                }
            }
        }
    }
}

@Composable
fun OrderCard(order: PizzaOrder) {
    Card(
        shape = RoundedCornerShape(14.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(order.pizza.imageRes),
                contentDescription = order.pizza.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(84.dp)
                    .padding(end = 12.dp)
            )

            Column(modifier = Modifier.weight(1f)) {
                Text(order.pizza.name, fontWeight = FontWeight.SemiBold)
                Spacer(Modifier.height(6.dp))
                Text(order.pizza.description, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}
