import {LOGIN_USER_ENDPOINT} from './Endpoints';
import {makeUrl} from '../../config/Utility';
import axios from 'axios';

export default function loginUser(input) {
    return axios.post(makeUrl(LOGIN_USER_ENDPOINT), {...input})
      .then(res => {
        console.log(res);
        console.log(res.data);
      })
};

