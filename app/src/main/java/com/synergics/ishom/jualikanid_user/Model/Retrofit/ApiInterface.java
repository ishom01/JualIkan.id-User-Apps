package com.synergics.ishom.jualikanid_user.Model.Retrofit;

import com.synergics.ishom.jualikanid_user.Controller.GMapsTrack.GMapsAdress;
import com.synergics.ishom.jualikanid_user.Model.Retrofit.Object.ResponseBantuan;
import com.synergics.ishom.jualikanid_user.Model.Retrofit.Object.ResponseFish;
import com.synergics.ishom.jualikanid_user.Model.Retrofit.Object.ResponseHome;
import com.synergics.ishom.jualikanid_user.Model.Retrofit.Object.ResponseKategori;
import com.synergics.ishom.jualikanid_user.Model.Retrofit.Object.ResponseKeranjang;
import com.synergics.ishom.jualikanid_user.Model.Retrofit.Object.ResponseKota;
import com.synergics.ishom.jualikanid_user.Model.Retrofit.Object.ResponseLogin;
import com.synergics.ishom.jualikanid_user.Model.Retrofit.Object.ResponseMessage;
import com.synergics.ishom.jualikanid_user.Model.Retrofit.Object.ResponseMidtransSnap;
import com.synergics.ishom.jualikanid_user.Model.Retrofit.Object.ResponseOrderDetail;
import com.synergics.ishom.jualikanid_user.Model.Retrofit.Object.ResponseOrderProcessed;
import com.synergics.ishom.jualikanid_user.Model.Retrofit.Object.ResponsePembayaran;
import com.synergics.ishom.jualikanid_user.Model.Retrofit.Object.ResponseProfile;
import com.synergics.ishom.jualikanid_user.Model.Retrofit.Object.ResponseRegister;
import com.synergics.ishom.jualikanid_user.Model.Retrofit.Object.ResponseReview;
import com.synergics.ishom.jualikanid_user.Model.Retrofit.Object.ResponseSaldo;
import com.synergics.ishom.jualikanid_user.Model.Retrofit.Object.ResponseTrackingOrder;
import com.synergics.ishom.jualikanid_user.Model.TrackMaps.Direction;
import com.synergics.ishom.jualikanid_user.Model.TrackMaps.NearbyLocation;
import com.synergics.ishom.jualikanid_user.View.Object.MidtransPayment;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by asmarasusanto on 10/8/17.
 */

public interface ApiInterface {

    //================================= Google Maps endpoint web service ============================================//

    @GET("directions/json?key=AIzaSyBoFfYEuwzXaVwF07dt30KvYZM9vJXUGb0")
    Call<Direction> getDirection(@Query("origin") String origin,
                                 @Query("destination") String destionation,
                                 @Query("waypoints") String waypoint,
                                 @Query("sensor") boolean sensor,
                                 @Query("mode") String mode);

    @GET("directions/json?key=AIzaSyBoFfYEuwzXaVwF07dt30KvYZM9vJXUGb0")
    Call<Direction> getDirection(@Query("origin") String origin,
                                              @Query("destination") String destionation,
                                              @Query("sensor") boolean sensor,
                                              @Query("mode") String mode);

    @GET("geocode/json?key=AIzaSyBoFfYEuwzXaVwF07dt30KvYZM9vJXUGb0")
    Call<GMapsAdress> getAddress(@Query("latlng") String origin,
                                 @Query("sensor") boolean sensor);

    @GET("place/nearbysearch/json?key=AIzaSyBoFfYEuwzXaVwF07dt30KvYZM9vJXUGb0")
    Call<NearbyLocation> getNearby(@Query("location") String location,
                                   @Query("radius") String radius,
                                   @Query("types") String type);

    //================================= JualIkan.id endpoint web service ============================================//

    @POST("transactions")
    Call<ResponseMidtransSnap> snapMidtrans(@Header("Authorization") String auth,
                                            @Header("Content-Type") String content_type,
                                            @Header("Accept") String accept,
                                            @Body MidtransPayment body);

    //====================================  midtrans endpoint web service  ===========================================//

    @Multipart
    @POST("login.php")
    Call<ResponseLogin> login(@Part("phone") RequestBody email,
                              @Part("password") RequestBody pass,
                              @Part("device_id") RequestBody device_id);

    @Multipart
    @POST("register.php")
    Call<ResponseRegister> register(@Part("full_name") RequestBody full_name,
                                    @Part("phone") RequestBody phone,
                                    @Part("email") RequestBody email,
                                    @Part("password") RequestBody password,
                                    @Part("kota_id") RequestBody kota_id,
                                    @Part("alamat") RequestBody alamat);

    @Multipart
    @POST("order-post.php")
    Call<ResponseRegister> postOrder(@Part("postIdKeranjang") RequestBody postIdKeranjang,
                                     @Part("postIdUser") RequestBody postIdUser,
                                     @Part("postAlamat") RequestBody postAlamat,
                                     @Part("postLatAlamat") RequestBody postLatAlamat,
                                     @Part("postLngAlamat") RequestBody postLngAlamat,
                                     @Part("postPaymentType") RequestBody postPaymentType,
                                     @Part("postIdKoperasi") RequestBody postIdKoperasi,
                                     @Part("postWaktuPengiriman") RequestBody postWaktuPengiriman,
                                     @Part("postJarakPengiriman") RequestBody postJarakPengiriman,
                                     @Part("postPaymentUrl") RequestBody postPaymentUrl,
                                     @Part("postBiayaPengiriman") RequestBody postBiayaPengiriman,
                                     @Part("postBeratOrder") RequestBody postBeratOrder,
                                     @Part("postTotalPembayaran") RequestBody postTotalPembayaran,
                                     @Part("postIdWaktuPengiriman") RequestBody postIdWaktuPengiriman,
                                     @Part("postOrderStatus") RequestBody postOrderStatus);

    @Multipart
    @POST("menu2.php")
    Call<ResponseHome> menu(@Part("lat") RequestBody lat,
                            @Part("lng") RequestBody lng,
                            @Part("user_id") RequestBody user_id);

    @Multipart
    @POST("cart.php")
    Call<ResponseKeranjang> keranjang(@Part("id_user") RequestBody id_user,
                                      @Part("cart_id") RequestBody cart_id,
                                      @Part("jumlah") RequestBody jumlah);

    @Multipart
    @POST("get-processed-order.php")
    Call<ResponseOrderProcessed> orderProcessed(@Part("id_user") RequestBody id_user);

    @Multipart
    @POST("get-expired-order.php")
    Call<ResponseOrderProcessed> orderFinished(@Part("id_user") RequestBody id_user);

    @Multipart
    @POST("payment_detail.php")
    Call<ResponsePembayaran> payment_detail(@Part("id_user") RequestBody id_user);

    @GET("kota.php")
    Call<ResponseKota> kota();

    @Multipart
    @POST("category_fish.php")
    Call<ResponseKategori> kategori(@Part("cat_id") RequestBody cat);

    @Multipart
    @POST("koperasi_fish.php")
    Call<ResponseKategori> koperasi_fish(@Part("koperasi_id") RequestBody cat);

    @Multipart
    @POST("search_fish.php")
    Call<ResponseKategori> serach_kategori(@Part("cat_id") RequestBody cat,
                                    @Part("search") RequestBody search);

    @Multipart
    @POST("koperasi_search_fish.php")
    Call<ResponseKategori> search_koperasi(@Part("koperasi_id") RequestBody cat,
                                           @Part("search") RequestBody search);

    @Multipart
    @POST("processed-order-detail.php")
    Call<ResponseOrderDetail> processed_order_detail(@Part("order_id") RequestBody order_id);

    @Multipart
    @POST("fish.php")
    Call<ResponseFish> fish(@Part("fish_id") RequestBody fish_id);

    @Multipart
    @POST("bantuan.php")
    Call<ResponseBantuan> bantuan(@Part("user_level") RequestBody user_level);

    @Multipart
    @POST("search_bantuan.php")
    Call<ResponseBantuan> serach_bantuan(@Part("user_level") RequestBody user_level,
                                         @Part("search") RequestBody search);

    @Multipart
    @POST("first-add-cart.php")
    Call<ResponseMessage> addkeranjang(@Part("user_id") RequestBody user,
                                       @Part("fish_id") RequestBody fish,
                                       @Part("lat") RequestBody lat,
                                       @Part("lng") RequestBody lng,
                                       @Part("koperasi_id") RequestBody koperasi);

    @Multipart
    @POST("order-detail-tracking.php")
    Call<ResponseTrackingOrder> trackingOrder(@Part("order_id") RequestBody order_id);

    @Multipart
    @POST("review-get.php")
    Call<ResponseReview> getReview(@Part("user_id") RequestBody user_id,
                                   @Part("fish_id") RequestBody fish_id,
                                   @Part("koperasi_id") RequestBody koperasi_id);


    @Multipart
    @POST("review-post.php")
    Call<ResponseMessage> postReview(@Part("user_id") RequestBody user_id,
                                   @Part("fish_id") RequestBody fish_id,
                                   @Part("koperasi_id") RequestBody koperasi_id,
                                   @Part("review_text") RequestBody review_text,
                                   @Part("review_value") RequestBody review_value);

    @Multipart
    @POST("riwayat_saldo.php")
    Call<ResponseSaldo> saldo_history(@Part("user_id") RequestBody driver_id);

    @Multipart
    @POST("profile.php")
    Call<ResponseProfile> profile(@Part("user_id") RequestBody driver_id);

    @Multipart
    @POST("update_profile.php")
    Call<ResponseMessage> update_profile(@Part("user_id") RequestBody driver_id,
                                         @Part("old_password") RequestBody old_password,
                                         @Part("new_password") RequestBody new_password);

    @Multipart
    @POST("update_saldo.php")
    Call<ResponseMessage> tambah_saldo(@Part("user_id") RequestBody driver_id,
                                         @Part("saldo") RequestBody saldo);

}
