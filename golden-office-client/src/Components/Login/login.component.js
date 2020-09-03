import {LOGIN_USER_ENDPOINT} from './Endpoints';
import axios from 'axios';

export default async function loginUser(input) {
    return axios.post(LOGIN_USER_ENDPOINT, {...input})
      .then(res => {
        console.log(res);
        console.log(res.data);
      })
};

