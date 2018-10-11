# Forked from original

- On branch: `shuga-text-block-scanner`, Added dependency on Shuga OCR for drawing text block, example usage:

      ```
      <RNCamera
        ref={ref => {
          this.camera = ref;
        }}
        style = {styles.preview}
        type={RNCamera.Constants.Type.back}
        flashMode={RNCamera.Constants.FlashMode.on}

        textBlockDetectionEnabled={true}
        onTextBlockDetectionChange={this.onTextBlockDetectionChange}
        //At least how many time passed until we check the frame for text block again, value in ms, e.g. {1000} means 1 seconds
        textBlockChangeMinimumCooldown={1000}
        //Text block to view ratio must be at least {min_threshold} for us to draw or return anything, value is percentage (0~100)
        textBlockMinThreshold={50}
        //Text block to view ratio must be at most {max_threshold} for us to draw or return anything, value is percentage (0~100)
        textBlockMaxThreshold={100}
        //Good: text block area to view ratio is between {min_threshold} and {max_threshold}
        textBlockGoodStrokeColor={"#2ff64d"}
        textBlockGoodStrokeWidth={4.0}
        //Bad: text block area to view ratio is NOT between {min_threshold} and {max_threshold}, set stroke width to 0 to not show
        textBlockBadStrokeColor={"#f62200"}
        textBlockBadStrokeWidth={0}

        permissionDialogTitle={'Permission to use camera'}
        permissionDialogMessage={'We need your permission to use your camera phone'}
      />
      ```
