import React, { FC, ReactElement } from "react";
import { Carousel } from "antd";
import { Link } from "react-router-dom";
import { MENU } from "../../../constants/routeConstants";
import "./CarouselImageSlider.css";

export const sliderItems = [
    {
        id: "female",
        name: "Photo 1",
        url: "https://i.ibb.co/jMmJs60/Them-Woman-ENG.jpg"
    },
    {
        id: "male",
        name: "Photo 2",
        url: "https://i.ibb.co/mJGKz8c/Them-Man-ENG.jpg"
    }
];

const CarouselImageSlider: FC = (): ReactElement => {
    return (
        <Carousel>
            {sliderItems.map((item) => (
                <div key={item.id} className={"carousel-item-wrapper"}>
                    
                    <Link to={{ pathname: MENU, state: { id: item.id } }} className={"carousel-link"} />
                    <img style={{width:910,margin:"0 auto"}} src={item.url} alt={item.name} />
                </div>
            ))}
        </Carousel>
    );
};

export default CarouselImageSlider;
