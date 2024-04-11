import React from 'react';
import {MapTo} from '@adobe/aem-react-editable-components';

require('./Hero.css');

const HeroEditConfig = {
    emptyLabel: 'hero component',
    isEmpty: (props) => !props || !props.text || !props.linklabel
}

const Hero = (props) => {
    const {text, linklabel, link, mobileImage} = props;

    if(HeroEditConfig.isEmpty(props)) {
        return null;
    }

    return (
        <div className="hero">
            <p>{text}</p>
            <a href={link}>{linklabel}</a>
            <img src = {mobileImage} />
        </div>
    );
}


MapTo('wknd-spa-react/components/hero')(Hero,HeroEditConfig);
export default Hero 
