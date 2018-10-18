package org.reactnative.camera.events;

import android.support.v4.util.Pools;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

import org.reactnative.camera.CameraViewManager;

public class TextBlockDetectionChangeEvent extends Event<TextBlockDetectionChangeEvent> {
    private static final Pools.SynchronizedPool<TextBlockDetectionChangeEvent> EVENTS_POOL = new Pools.SynchronizedPool<>(5);

    private TextBlockDetectionChangeEvent() {
    }

    private WritableMap mResponse;

    public static TextBlockDetectionChangeEvent obtain(int viewTag, WritableMap response) {
        TextBlockDetectionChangeEvent event = EVENTS_POOL.acquire();
        if (event == null) {
            event = new TextBlockDetectionChangeEvent();
        }
        event.init(viewTag, response);
        return event;
    }

    private void init(int viewTag, WritableMap response) {
        super.init(viewTag);
        mResponse = response;
    }

    @Override
    public short getCoalescingKey() {
        int hashCode = mResponse.getInt("time");
        return (short) hashCode;
    }

    @Override
    public String getEventName() {
        return CameraViewManager.Events.EVENT_ON_TEXTBLOCK_DETECTION_CHANGE.toString();
    }

    @Override
    public void dispatch(RCTEventEmitter rctEventEmitter) {
        rctEventEmitter.receiveEvent(getViewTag(), getEventName(), mResponse);
    }
}
