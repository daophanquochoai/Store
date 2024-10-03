import React from 'react';
import {ParallaxBanner} from "react-scroll-parallax";

const Info = () => {
    return (
        <div className={'bg-yellow_primary mt-16 h-[520px] info-background'}>
            <div className={'mx-[10%] grid grid-cols-[1fr_1fr]'}>
                <div className={'flex justify-center items-center flex-col'}>
                    <h3 className={'text-3xl'}>
                        Get <span className={'text-green_primary'}>25% Discount</span> on your first purchase
                    </h3>
                    <p className={'mt-4 text-base text-gray_primary'}>Just Sign Up & Register it now to become member.</p>
                    <input placeholder={"Email"} className={'outline-0 py-2 px-6 text-xl w-full rounded-[10px] mt-4'}/>
                    <button className={'w-full bg-black mt-4 p-2 text-white text-xl rounded-[10px]'}>Subscribe</button>
                </div>
                <div className={'overflow-hidden h-[520px]'}>
                    <img src={'https://demo.templatesjungle.com/foodfarm/images/banner-girl.png'} alt={'image'}/>
                </div>
            </div>
        </div>
    );
};

export default Info;