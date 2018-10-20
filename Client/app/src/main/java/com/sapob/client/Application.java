package com.sapob.client;

import com.sapob.client.data.DataModel;
import com.sapob.client.data.SampleData;

public class Application {
    public static DataModel getDataModel() {
        return dataModel;
    }

    private static DataModel dataModel = new SampleData();
}
