package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@3.0.1 */
final class zzak {
    static final BillingResult zza = BillingResult.newBuilder().setResponseCode(3).setDebugMessage("Google Play In-app Billing API version is less than 3").build();
    static final BillingResult zzb = BillingResult.newBuilder().setResponseCode(3).setDebugMessage("Google Play In-app Billing API version is less than 9").build();
    static final BillingResult zzc = BillingResult.newBuilder().setResponseCode(3).setDebugMessage("Billing service unavailable on device.").build();
    static final BillingResult zzd = BillingResult.newBuilder().setResponseCode(5).setDebugMessage("Client is already in the process of connecting to billing service.").build();
    static final BillingResult zze = BillingResult.newBuilder().setResponseCode(3).setDebugMessage("Play Store version installed does not support cross selling products.").build();
    static final BillingResult zzf = BillingResult.newBuilder().setResponseCode(5).setDebugMessage("The list of SKUs can't be empty.").build();
    static final BillingResult zzg = BillingResult.newBuilder().setResponseCode(5).setDebugMessage("SKU type can't be empty.").build();
    static final BillingResult zzh = BillingResult.newBuilder().setResponseCode(-2).setDebugMessage("Client does not support extra params.").build();
    static final BillingResult zzi = BillingResult.newBuilder().setResponseCode(-2).setDebugMessage("Client does not support the feature.").build();
    static final BillingResult zzj = BillingResult.newBuilder().setResponseCode(-2).setDebugMessage("Client does not support get purchase history.").build();
    static final BillingResult zzk = BillingResult.newBuilder().setResponseCode(5).setDebugMessage("Invalid purchase token.").build();
    static final BillingResult zzl = BillingResult.newBuilder().setResponseCode(6).setDebugMessage("An internal error occurred.").build();
    static final BillingResult zzm = BillingResult.newBuilder().setResponseCode(5).setDebugMessage("SKU can't be null.").build();
    static final BillingResult zzn = BillingResult.newBuilder().setResponseCode(0).build();
    static final BillingResult zzo = BillingResult.newBuilder().setResponseCode(-1).setDebugMessage("Service connection is disconnected.").build();
    static final BillingResult zzp = BillingResult.newBuilder().setResponseCode(-3).setDebugMessage("Timeout communicating with service.").build();
    static final BillingResult zzq = BillingResult.newBuilder().setResponseCode(-2).setDebugMessage("Client doesn't support subscriptions.").build();
    static final BillingResult zzr = BillingResult.newBuilder().setResponseCode(-2).setDebugMessage("Client doesn't support subscriptions update.").build();
    static final BillingResult zzs = BillingResult.newBuilder().setResponseCode(-2).setDebugMessage("Client doesn't support multi-item purchases.").build();
    static final BillingResult zzt = BillingResult.newBuilder().setResponseCode(5).setDebugMessage("Unknown feature").build();
    private static final BillingResult zzu = BillingResult.newBuilder().setResponseCode(4).setDebugMessage("Item is unavailable for purchase.").build();
    private static final BillingResult zzv = BillingResult.newBuilder().setResponseCode(5).setDebugMessage("SKU type can't be null.").build();
}
