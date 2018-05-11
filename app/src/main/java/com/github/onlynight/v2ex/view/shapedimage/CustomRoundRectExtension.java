package com.github.onlynight.v2ex.view.shapedimage;

import android.graphics.Path;
import android.graphics.RectF;

import cn.gavinliu.android.lib.shapedimageview.ShapedImageView;

public class CustomRoundRectExtension implements ShapedImageView.PathExtension {

    private float topLeft;
    private float topRight;
    private float bottomLeft;
    private float bottomRight;

    public CustomRoundRectExtension(float topLeft, float topRight, float bottomLeft, float bottomRight) {
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }

    @Override
    public void onLayout(Path path, int width, int height) {
        path.reset();

        // top left
        path.lineTo(0, 0);
        path.lineTo(0, topLeft);
        path.arcTo(new RectF(0, 0, topLeft * 2, topLeft * 2), 180, 90);
        path.lineTo(topLeft, 0);

        // top right
        path.moveTo(width - topRight, 0);
        path.lineTo(width, 0);
        path.lineTo(width, topRight);
        path.arcTo(new RectF(width - topRight * 2, 0, width, topRight * 2), 0, -90);

        // bottom left
        path.moveTo(0, height - bottomLeft);
        path.lineTo(0, height);
        path.lineTo(bottomRight, height);
        path.arcTo(new RectF(0, height - bottomLeft * 2, bottomLeft * 2, height), 90, 90);

        // bottom right
        path.moveTo(width, height - bottomRight);
        path.lineTo(width, height);
        path.lineTo(width - bottomRight, height);
        path.arcTo(new RectF(width - bottomRight * 2, height - bottomRight * 2, width, height), 90, -90);
    }

}
