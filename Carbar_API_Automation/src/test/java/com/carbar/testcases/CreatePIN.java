package com.carbar.testcases;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class CreatePIN {

	public static void main(String[] args) {

		String accessToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiI5NDVhMzNjYy1lZGQzLTRjYWQtOTcwZi1kZjUxOTFmMGI1MGIiLCJqdGkiOiI3ZTc4YzFiZTEwZTU3YzU4YWMyNTE3YmI1MDUxZDQzZmUxYzA1YzhlNWM5MmJjM2I2MjNmMmMzYTJhMzhjOGI2MzQwZjgwOTcxYjAwZTllZCIsImlhdCI6MTY0MTQ0OTU1OCwibmJmIjoxNjQxNDQ5NTU4LCJleHAiOjE2NDQwNDE1NTgsInN1YiI6IjIyNDMyIiwic2NvcGVzIjpbXX0.gQHc1FFp6l2nbCnD5RKN_P61R9ZXVkUwWYYZ5vcRwwpt8zbmt191uQlJjAtBi3L-C5DcpgPqHzCq4vSPN9dgpMFZzlrtfzDEPVmHlHzS6wzB38aDgOBiNiC4o2_MP5LEp980e83yL7O25cNUvhy_baiUN3G1Jong6PHLV5DSbACrH2kh3Snmgdef8iNni3y6E3QVvr5FnatVdg02l8eoWvpmlWVcjY_QdtqTj_cp1ZfH7rp-RXzj0z7nbP5qIqeOxz3D7E3iw0LlJf5CaLIobUpCC2eHug26bOkS8GoZmh5-BYtvXZDf9ldzI5WVkkLeoOGhfC4U5z1bRz_SLDW7U_G2_RVrQQWm8LV28OIFusR15e0YiFWiq7LMzP_rL8NEeOtvIrAr7FjMlGLqVPNs2S8zBIyxO3p-nR58jNDpWW7QiSf8THYV5cBmnsePlgqGK3_k_yWQodET_saghXvUxMV-_5nv_aW4AXh6MgK5AfNiLc2dtfdQpzz8f-Zif1LqE8xI6q1pDXF-KGgjq5qFGYU0lDQSP8uppm5GTmkzVkYpxf-Zm7yRkwmY2T2XjlstZRXSdx0cQuj6i-624dcibfS32L-VH2U7fEuiTvqP5gDLNVBqG5gy2Di_k646ZXjLHXPSG6IKSM6wU_EDWYRC_bB5scVqLWWm8N7AjNpkeP4";
		RestAssured.baseURI = "https://api-test.carbar.com.au";
		//Get Place
		
		String GetResponse =given().log().all().queryParam("pin","3305").
				queryParam("pin_confirmation","3305").
			header("Authorization", "Bearer "+accessToken).
			header("Accept","application/json").
	        when().post("/create-pin").
	        then().log().all().assertThat().statusCode(200).extract().response().asString();
	
System.out.println("GetResponse:"+GetResponse);

  /*   {
	  "access_token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiI5NDVhMzNjYy1lZGQzLTRjYWQtOTcwZi1kZjUxOTFmMGI1MGIiLCJqdGkiOiI2YzIxMTQ1ODk3MzYyZGFjYjQzOTEwNWZiNmUwM2MwOGY1YzAyODRlOTE4MDUxMDJlYzcxNTRmMmU1ZmJlM2FhM2YzMTRkMzg1ODczNjEwYyIsImlhdCI6MTY0MTk3MDM1MiwibmJmIjoxNjQxOTcwMzUyLCJleHAiOjE2NDQ1NjIzNTIsInN1YiI6IjE4MDk0Iiwic2NvcGVzIjpbXX0.lW3lXYajbzl9EDOP2frsn9eytFDqieCJMu7ghr44DCAtqQbzCgP71BI398XJ8oGSqKZ5swbGTxDgxR7sbX18HhvSvczcM7p8pLQm44RCx66TlOf_pNv_Bm9cbuRUZaZzuy0njWKvt9UyjPgbbsgiT9J2fEaFVl0kwDEW2KCjPFB89Xo7ylyZqhCZELIiSJdTXpbgM8u9C20ml2cN5K803pUFjbHDKVYmofhZ9ctaxe03OYMm3pstZcJ7c5ceeb_KxG7YWIEHgGkiS5Qb9hgvDQD6T9PFdG2FbQX2XxPNejuOWwLQTGzQuvWNHyWnWWHqrfBSG1vD_Yd9QdWGQ5LqmJC0zErAiTwYdjCtGY20bdApQ9nEqnVxOASVmH1xdf9gelAd6Los784GkbOznCVnG7HKdX9ZWzn5_sS0yc_Nn5W5On7xi45_ScSva-kKtL2IwFAjxE03RUnQHcCpv9KvYq0T5RrxmKcTod8eKoBdxUJpuNmImWkrCPnF5ir1QbgjJcDBzKiEvSdJDy-ZmWYtJ28IEEqQudT1fvqHWNufsq6msZhl8AF2uI0wh-gz1t1Rces-g_kal9AOuHodfppdb-TICfQhUqmrBRiSb_40e-G2bDSjSZ_BYRfg0BN7wVNVak6E-qrhiFy9DwxpOKXT7ad58e_nJzU1pdoL1EaJLmA",
	  "expires_at": "2022-02-11T06:52:32.000000Z"
	}
  */
	}

}
