import React from 'react';
import {Input} from "antd";
import { UserOutlined } from '@ant-design/icons';
import {RiLockPasswordLine} from "react-icons/ri";
import {NavLink} from "react-router-dom";
import {FaFacebook, FaGithub} from "react-icons/fa";
import {getSocialLoginUrl} from "../Helper/Helper.ts";

const Login : React.FC = () => {
    return (
        <div className={'w-full h-[100vh] flex items-center justify-center'}>
            <div className={'border-2 rounded-2xl overflow-hidden shadow_form'}>
                <div className={'bg-green_primary w-[400px] p-4'}>
                    <h2 className={'text-center text-3xl text-white font-bold'}>Sign In</h2>
                </div>
                <div className={'px-5 mt-8'}>
                    <Input size="large" placeholder="User name" prefix={<UserOutlined />} />
                </div>
                <div className={'px-5 mt-8'}>
                    <Input size="large" placeholder="Password" prefix={<RiLockPasswordLine />} />
                </div>
                <div className={'flex items-center justify-center'}>
                    <button className={'mt-8 bg-green_primary text-white w-[50%] py-2 rounded-2xl hover:bg-white border-2 border-green_primary hover:text-green_primary'}>Login</button>
                </div>
                <div className={'flex gap-6 items-center justify-center mt-8'}>
                    <div className={'text-4xl text-green_primary cursor-pointer'}><a href={getSocialLoginUrl('github')}><FaGithub /></a></div>
                    <div className={'text-4xl text-green_primary cursor-pointer'}><FaFacebook/></div>
                </div>
                <div className={'flex flex-col items-center justify-center mt-16 mb-2'}>
                    <NavLink to={'/forget-account'} className={'text-gray-300'}>Forget account ?</NavLink>
                    <NavLink className={'text-green-300'} to={'/register'}>Sign Up</NavLink>
                </div>
            </div>
        </div>
    );
};

export default Login;