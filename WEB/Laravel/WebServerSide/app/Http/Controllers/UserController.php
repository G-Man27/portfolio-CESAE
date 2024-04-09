<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class UserController extends Controller
{
    public function allUsers() {

        $allUsers= $this->getUsers();
        // $allUsersInfo= $this->getUsersInfo();

    return view('users.all_users',compact('allUsers'/*,'allUsersInfo'*/,));
    }

/*     protected function getUsers(){
        $users=[
            [1,'Ana','912226847'],
            [2,'Luís','915156414'],
            [3,'Miguel','915551782'],
            [4,'Jessica','351+ 956915397'],
        ];

        return $users;
    }
 */
    protected function getUsers(){
        $users=[
            ['id'=>1, 'name'=>'Ana', 'phone'=>'912226847'],
            ['id'=>2, 'name'=>'Luís', 'phone'=>'915156414'],
            ['id'=>3, 'name'=>'Miguel', 'phone'=>'915551782'],
            ['id'=>4, 'name'=>'Jessica', 'phone'=>'351+ 956915397'],
        ];

        return $users;
    }

    /* private function getUsersInfo(){
        $usersInfo = [
            '1'=>[
                'name'=>'Cesae',
                'address'=>'Rua Ciríaco Cardoso 186, 4150-212 Porto',
                'email'=>'cesae@cesae.pt'
            ],
            '2'=>[
                'name'=>'Cesa',
                'address'=>'Rua Ciríaco Cardoso 186, 4150-212 Porto',
                'email'=>'cesae@cesae.pt'
            ]
        ];
        return $usersInfo;
    }*/
}
