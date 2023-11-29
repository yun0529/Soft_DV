package com.gnu.softdv.util

import android.graphics.Canvas
import android.graphics.Paint
import androidx.annotation.ColorInt
import androidx.recyclerview.widget.RecyclerView

// 리사이클러뷰의 각 아이템 구분선을 정의하는 클래스
class CustomDecoration(private val height: Float, private val padding: Float, @ColorInt private val color: Long) : RecyclerView.ItemDecoration() {
    private val paint = Paint()
    init { // 패인트 변수 초기화
        paint.color = color.toInt()
    }
    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) { // 구분선을 그리는 메소드

        val left = parent.paddingStart + padding // 왼쪽 패딩 정의
        val right = parent.width - parent.paddingEnd - padding // 오른쪽 패딩 정의

        for (i in 1 until parent.childCount) { // 아이템의 개수에 맞게 구분선을 출력
            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams
            val top = (child.bottom + params.bottomMargin).toFloat()
            val bottom = top + height
            c.drawRect(left, top, right, bottom, paint)
        }
    }
}