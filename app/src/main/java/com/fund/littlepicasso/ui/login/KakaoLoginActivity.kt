package com.fund.littlepicasso.ui.login

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.fund.littlepicasso.databinding.ActivityKakaoLoginBinding
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.util.Utility
import com.kakao.sdk.user.UserApiClient

class KakaoLoginActivity: AppCompatActivity() {
    companion object{
        const val KAKAO_TAG ="kakaoTag"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityKakaoLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var keyHash = Utility.getKeyHash(this)
        Log.d(KAKAO_TAG,keyHash)

        //콜백 함수 : 로그인 결과에 따라 필요한 동작과 예외 처리
        val loginCallback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if(error!= null){
                Log.e("LoginTest", "로그인 실패", error)
            }
            else if(token!=null){
                Log.i("LoginTest", "로그인 성공 ${token.accessToken}")
                //사용자 정보 가져오기
                UserApiClient.instance.me { user, error ->
                    if(error!=null){
                        Log.e(KAKAO_TAG, "사용자 정보 요청 실패", error)
                    }
                    else if(user!=null){
                        Log.i(KAKAO_TAG, "사용자 정보 요청 성공" +
                                "\n회원번호: ${user.id}" +
                                "\n이메일: ${user.kakaoAccount?.email}" +
                                "\n닉네임: ${user.kakaoAccount?.profile?.nickname}" +
                                "\n간편가입 시간: ${user.synchedAt}" +
                                "\n서비스 연결 완료 시간: ${user.connectedAt}" +
                                "\nproperties: ${user.properties}" +
                                "\n프로필사진: ${user.kakaoAccount?.profile?.thumbnailImageUrl}")
                    }
                }
            }
        }

        binding.signInButton.setOnClickListener {
            //카카오톡이 설치되어 있는지 확인
            if(UserApiClient.instance.isKakaoTalkLoginAvailable(this@KakaoLoginActivity)){
                //카카오톡으로 로그인
                UserApiClient.instance.loginWithKakaoTalk(this@KakaoLoginActivity, callback = loginCallback)
            } else{
                //기본 웹 브라우저를 통해 카카오계정으로 로그인
                UserApiClient.instance.loginWithKakaoAccount(this@KakaoLoginActivity, callback = loginCallback)
            }
        }

    }

}