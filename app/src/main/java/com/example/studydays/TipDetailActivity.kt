package com.example.studydays

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class TipDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.activity_tip_detail)
        val root = findViewById<View>(R.id.root)
        ViewCompat.setOnApplyWindowInsetsListener(root) { view, windowInsets ->
            val bars = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            windowInsets
        }
        val controller = WindowCompat.getInsetsController(window, root)
        controller.isAppearanceLightStatusBars = true
        controller.isAppearanceLightNavigationBars = true

        val day = intent.getIntExtra(EXTRA_DAY, NO_DAY)
        val tip = TipRepository.tips.find { it.day == day }
        if (tip == null) {
            finish()
            return
        }

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        toolbar.setNavigationOnClickListener { finish() }
        toolbar.title = getString(R.string.day_label, tip.day)

        findViewById<ImageView>(R.id.detailImage).apply {
            setImageResource(tip.imageRes)
            contentDescription = getString(tip.titleRes)
        }
        findViewById<TextView>(R.id.detailTitle).setText(tip.titleRes)
        findViewById<TextView>(R.id.detailBody).setText(tip.bodyRes)
    }

    companion object {
        const val EXTRA_DAY = "extra_day"
        private const val NO_DAY = -1
    }
}
