import {CREATE_USER_ENDPOINT} from './Endpoints';
import axios from 'axios';

export default function registerUser(input) {
    return axios.post(CREATE_USER_ENDPOINT, {...input})
      .then(res => {
        console.log(res);
        console.log(res.data);
      })
};
