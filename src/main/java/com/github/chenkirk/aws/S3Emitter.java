package com.github.chenkirk.aws;

import com.amazonaws.services.kinesis.connectors.s3.S3Emitter;
import java.io.IOException;
import java.lang.String;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class S3Emitter extends com.amazonaws.services.kinesis.connectors.s3.S3Emitter {
    @Override
    public String getS3FileName(String firstSeq, String lastSeq) {
        SimpleDateFormat dateFormatUtc = new SimpleDateFormat("yyyy'/'MM'/'dd'/'HH'/'");
        dateFormatUtc.setTimeZone(TimeZone.getTimeZone("UTC"));
        String folderName = dateFormatUtc.format(new Date()).toString();
        return folderName + firstSeq + "-" + lastSeq;
    }
}
