# quarkus-azure-functions-http

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/quarkus-azure-functions-blob-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Test using Azure Functions Core Tools (native mode)

Build to run locally
```
mvn clean package -Pnative
```

Build do publish on Azure
```
mvn clean package -Pnative -Dquarkus.native.container-build=true -Dquarkus.native.builder-image=quay.io/quarkus/ubi-quarkus-mandrel-builder-image:22.3.2.1-Final-java17
```

```
cp target/quarkus-azure-functions-blob-1.0.0-SNAPSHOT-runner functions/
```

```
cd functions
```

Test local
```
func start
```

```
ulpload a file to blobcontainer
```

```
Request Example:

{
  "Data": {
    "file": "ewogICJ2ZXJzaW9uIjogMywKICAiYXJ0aWZhY3RUeXBlIjogewogICAgInR5cGUiOiAiQVBLIiwKICAgICJraW5kIjogIkRpcmVjdG9yeSIKICB9LAogICJhcHBsaWNhdGlvbklkIjogImJyLmNvbS5tYW51dGVubyIsCiAgInZhcmlhbnROYW1lIjogInJlbGVhc2UiLAogICJlbGVtZW50cyI6IFsKICAgIHsKICAgICAgInR5cGUICAgICAgImZpbHRlcnMiOiBbXSwKICAgICAgImF0dHJpYnV0ZXMiOiBbXSwKICAgICAgInZlcnNpb25Db2RlIjogNDE5NDM1MCwKICAgICAgInZlcnNpb25OYW1lIjogIjIuMC42IiwKICAgICAgIm91dHB1dEZpbGUiOiAiYXBwLXJlbGVhc2UuYXBrIgogICAgfQogIF0sCiAgImVsZW1lbnRUeXBlIjogIkZpbGUiCn0="
  },
  "Metadata": {
    "Uri": "\"https://testeinput.blob.core.windows.net/myblob/output-metadata.json"",
    "Properties": {
      "LastModified": "2023-05-31T13:28:51+00:00",
      "CreatedOn": "2023-05-31T13:18:04+00:00",
      "Metadata": {},
      "ObjectReplicationDestinationPolicyId": null,
      "ObjectReplicationSourceProperties": null,
      "BlobType": 0,
      "CopyCompletedOn": "0001-01-01T00:00:00+00:00",
      "CopyStatusDescription": null,
      "CopyId": null,
      "CopyProgress": null,
      "CopySource": null,
      "CopyStatus": 0,
      "BlobCopyStatus": null,
      "IsIncrementalCopy": false,
      "DestinationSnapshot": null,
      "LeaseDuration": 0,
      "LeaseState": 0,
      "LeaseStatus": 1,
      "ContentLength": 377,
      "ContentType": "application/json",
      "ETag": {},
      "ContentHash": "SK/c+G9WfXJNIQ3lT17FkA==",
      "ContentEncoding": null,
      "ContentDisposition": null,
      "ContentLanguage": null,
      "CacheControl": null,
      "BlobSequenceNumber": 0,
      "AcceptRanges": "bytes",
      "BlobCommittedBlockCount": 0,
      "IsServerEncrypted": true,
      "EncryptionKeySha256": null,
      "EncryptionScope": null,
      "AccessTier": "Hot",
      "AccessTierInferred": true,
      "ArchiveStatus": null,
      "AccessTierChangedOn": "0001-01-01T00:00:00+00:00",
      "VersionId": null,
      "IsLatestVersion": false,
      "TagCount": 0,
      "ExpiresOn": "0001-01-01T00:00:00+00:00",
      "IsSealed": false,
      "RehydratePriority": null,
      "LastAccessed": "0001-01-01T00:00:00+00:00",
      "ImmutabilityPolicy": {
        "ExpiresOn": null,
        "PolicyMode": null
      },
      "HasLegalHold": false
    },
    "Metadata": {},
    "name": "\"output-metadata.json\"",
    "sys": {
      "MethodName": "blobprocessor",
      "UtcNow": "2023-05-31T13:55:02.1264382Z",
      "RandGuid": "ca44fda7-c95b-4128-9b3f-fa21ba23644a"
    }
  }
}
```

Publish
1. Create Function App in Azure portal(runtime stack: custom handler, OS: Linux)
```
func azure functionapp publish <function app name>
```
