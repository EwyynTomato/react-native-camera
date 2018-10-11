// Copyright 2018 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.shuga.tbhelper;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Graphic instance for rendering TextBlock position, size, and ID within an associated graphic
 * overlay view.
 */
public class TextBoundingBoxGraphic extends GraphicOverlay.Graphic {

    private static final String TAG = "TextGraphic";

    private final Paint boxPaint;
    private final RectF rect;

    public TextBoundingBoxGraphic(GraphicOverlay overlay, RectF rect, int boxColor, float strokeWidth) {
        super(overlay);

        boxPaint = new Paint();
        boxPaint.setColor(boxColor);
        boxPaint.setStyle(Paint.Style.STROKE);
        boxPaint.setStrokeWidth(strokeWidth);

        this.rect = rect;

        // Redraw the overlay, as this graphic has been added.
        postInvalidate();
    }

    /**
     * Draws the text block annotations for position, size, and raw value on the supplied canvas.
     */
    @Override
    public void draw(Canvas canvas) {
        // Draws the bounding box around the TextBlock.
        canvas.drawRect(rect, boxPaint);
    }
}