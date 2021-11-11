package br.com.leandroid.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import br.com.leandroid.ui.R

class CardBeach
@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val name: TextView?

    init {
        inflate(context, R.layout.card_beach_widget, this)
        name = findViewById(R.id.name_card_beach)
        setAttribute(attrs)
    }

    fun setName(text: String?) {
        name?.text = text
    }

    private fun setAttribute(attrs: AttributeSet?) {
        val attributeSet = context.obtainStyledAttributes(attrs, R.styleable.CardBeachWidget)
        name?.text = attributeSet.getString(R.styleable.CardBeachWidget_name)
        attributeSet.recycle()
    }
}