$(()=>{
    new Login();
})

export class Login {
    constructor() {
        console.log('login')
        this.eventBindgin();
    }

    eventBindgin() {
        $('.btn_login').on('click', (e)=> {
            // console.log("bbb");

            let params = $('.login_form').serialize();
            console.log(params);

            $('form').submit();


            // axios.post(`/loginComplete`, params)
            //     .then(response => {
            //         // console.log('response : ', JSON.stringify(response, null, 2))
            //         console.log(response);
            //         alert('로그인 성공!');
            //         location.href='/main';
            //     }).catch(error => {
            //     console.log('failed', error)
            //     alert('로그인 실패!');
            //     location.href='/login';
            // })

        });



    }
}