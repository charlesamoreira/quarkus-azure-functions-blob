package org.acme;

public class Input {
    public final Data Data;
    public final Metadata Metadata;

    public Input(Data Data, Metadata Metadata){
        this.Data = Data;
        this.Metadata = Metadata;
    }

    public class Data {
        public final String file;

        public Data(String file){
            this.file = file;
        }
    }

    public class Metadata {
        public final String Uri;
        public final String name;

        public Metadata(String Uri, String name){
            this.Uri = Uri;
            this.name = name;
        }
    }
}