package com.example.aisle.ui.Widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aisle.ui.theme.buttonBorderColor
import com.example.aisle.ui.theme.greyColor
import com.example.aisle.ui.theme.inputFieldBorderColor
import com.example.aisle.ui.theme.inputLabelColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntryTextFields(
    textFieldValue: MutableState<TextFieldValue>,
    visualTransformation: VisualTransformation,
    size:Dp,
    width:Dp
) {

    Column(horizontalAlignment = Alignment.Start, modifier = Modifier.fillMaxWidth()) {
    }
    Spacer(modifier = Modifier.height(5.dp))
    OutlinedTextField(
        modifier = Modifier
            .width(width)
            .height(size),


        value = textFieldValue.value,
        visualTransformation = visualTransformation,
        textStyle = TextStyle(
            color = buttonBorderColor,
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password // HERE
        ),
        onValueChange = {
            textFieldValue.value = it
        },

        shape = RoundedCornerShape(percent = 20),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = inputFieldBorderColor,
            unfocusedBorderColor = inputFieldBorderColor,
            cursorColor = greyColor
        )
    )
}

