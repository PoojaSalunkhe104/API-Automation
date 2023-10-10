package com.carbar.testcases;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class FilterCountry {

	public static void main(String[] args) {
		
		
		String accessToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiI5NDVhMzNjYy1lZGQzLTRjYWQtOTcwZi1kZjUxOTFmMGI1MGIiLCJqdGkiOiI3ZTc4YzFiZTEwZTU3YzU4YWMyNTE3YmI1MDUxZDQzZmUxYzA1YzhlNWM5MmJjM2I2MjNmMmMzYTJhMzhjOGI2MzQwZjgwOTcxYjAwZTllZCIsImlhdCI6MTY0MTQ0OTU1OCwibmJmIjoxNjQxNDQ5NTU4LCJleHAiOjE2NDQwNDE1NTgsInN1YiI6IjIyNDMyIiwic2NvcGVzIjpbXX0.gQHc1FFp6l2nbCnD5RKN_P61R9ZXVkUwWYYZ5vcRwwpt8zbmt191uQlJjAtBi3L-C5DcpgPqHzCq4vSPN9dgpMFZzlrtfzDEPVmHlHzS6wzB38aDgOBiNiC4o2_MP5LEp980e83yL7O25cNUvhy_baiUN3G1Jong6PHLV5DSbACrH2kh3Snmgdef8iNni3y6E3QVvr5FnatVdg02l8eoWvpmlWVcjY_QdtqTj_cp1ZfH7rp-RXzj0z7nbP5qIqeOxz3D7E3iw0LlJf5CaLIobUpCC2eHug26bOkS8GoZmh5-BYtvXZDf9ldzI5WVkkLeoOGhfC4U5z1bRz_SLDW7U_G2_RVrQQWm8LV28OIFusR15e0YiFWiq7LMzP_rL8NEeOtvIrAr7FjMlGLqVPNs2S8zBIyxO3p-nR58jNDpWW7QiSf8THYV5cBmnsePlgqGK3_k_yWQodET_saghXvUxMV-_5nv_aW4AXh6MgK5AfNiLc2dtfdQpzz8f-Zif1LqE8xI6q1pDXF-KGgjq5qFGYU0lDQSP8uppm5GTmkzVkYpxf-Zm7yRkwmY2T2XjlstZRXSdx0cQuj6i-624dcibfS32L-VH2U7fEuiTvqP5gDLNVBqG5gy2Di_k646ZXjLHXPSG6IKSM6wU_EDWYRC_bB5scVqLWWm8N7AjNpkeP4";
		//    https://api-test.carbar.com.au/bodytypes?filters%5Bmanufacturer%5D=2
		RestAssured.baseURI = "https://api-test.carbar.com.au";
		//Get Place
				String GetResponse =given().log().all().header("Authorization", accessToken).header("Accept","application/json").
				when().get("/countries").andReturn().
				then().assertThat().statusCode(200).extract().response().asString();
				
		System.out.println("GetResponse:"+GetResponse);
	}

}
