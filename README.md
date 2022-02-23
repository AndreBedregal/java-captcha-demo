<h3 align="center">
  <img alt="Logo" title="#logo" src="/src/main/resources/samples/sample-captcha-1.jpeg">
  <img alt="Logo" title="#logo" src="/src/main/resources/samples/sample-captcha-2.jpeg">
  <br>
</h3>

# Java Captcha demo app

- [Purpose](#purpose)
- [Technologies](#techs)
- [Requirements](#reqs)
- [Architecture](#architecture)
- [Local Configuration](#localconfig)
- [Documentation](#docs)
- [Possible improvements](#improvements)

<a id="purpose"></a>
## Purpose

Demo API which generates a totally customizable captcha using [@akiraly/cage](https://github.com/akiraly/cage).

<a id="techs"></a>
## Technologies Used

- [Maven](https://maven.apache.org/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Cage](https://github.com/akiraly/cage)

<a id="reqs"></a>
## Requirements
- JDK (version 11+) installed.

<a id="architecture"></a>
## Architecture and directories

```
Project
├── src
|   ├── main
|   |   ├── java
|   |   |   ├── com.github.javacaptchademo
|   |   |   |   ├── captcha: Customized captcha generator.
|   |   |   |   ├── controller: Endpoints of the application.
|   |   |   |   ├── dto: Data transfer objects.
|   |   |   |   ├── service: Business rules to save the generated captcha in cache.
|   |   |   |   ├── JavaCaptchaDemoApplication.java: Entry point of the Spring Boot Application.
|   |   ├── resources
|   |   |   ├── fonts: Fonts to be used by the captcha generator.
|   |   |   ├── samples: Sample captcha images generated.
|   |   |   ├── application.properties: Properties of the application.
│   |── tests: Unit tests to validate business rules
├── package.json: File that manages all the dependecies and contains script definitions.

```
<a id="localconfig"></a>
## Local Configuration

- After cloning the project and installing JDK 11+, you can simply run `./mvnw spring-boot:run`.

<a id="docs"></a>
## Documentation

### GET: Request a new captcha

```
http://localhost:8080/captcha
```

Obtains a new captcha (Base64 encoded image) along with the captcha id.

```json
{
  "captchaId": "5ff6735a-ba78-4c97-8c8d-76b44ff06f3e",
  "captchaEncodedImage": "/9j/4AAQSkZJRgABAgAAAQABAAD/2wBDABALDA4MChAODQ4SERATGCgaGBYWGDEjJR0oOjM9PDkzODdASFxOQERXRTc4UG1RV19iZ2hnPk1xeXBkeFxlZ2P/2wBDARESEhgVGC8aGi9jQjhCY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2NjY2P/wAARCABGAMgDASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwD0Co3niQkNIoI9TUlZ+o6Yl4pYMVkxxg1cFFu0nYmbkleKLkU0cwzG4Ye1SVyKG80aY5BKd/SuhsNRhvIwVYB+61rVoOHvR1RlTrKektGXKiN1ACQZVyPesjW9XEYa3tz8/wDEw7VR0jTZLpvPlJ8oc/71VHD+5zzdiZV/f5IK51KsGXKnIPenVz73+owsUS3yoPy/SkGq6mD81vx+FL6tLo194/rEeqf3HQ0VjxeIIN22VCjd81pwzxzoGjYMDWU6U4fEjWNSM9mOlkWKNpG+6oyar22o21zxHIM+hqj4kuTFarEpILnn6VleH7Yz32/OFj5NbwoJ0nUkzCddqqoROtpaSlrkOoKKKKACimu6oMuwGeOaWgBaKKKACiiigAooooAKKKKACiimSSJEpZ2CgdzQAy5gjuIikoBX+VcfeBLO8YWkpIHcVoalqs17IbezB2ZxkdTVjTtAVMSXR3Mf4fSvRpfuI3qPfocFX99K0Ft1MjS7dLy9AnfA6nPeuxAjt4v4URRXKatYPYXPmxZEZOQR2qG61K4u444mY4HHHetKtJ4i0ovQinUVC8ZLU6f+1rLeV80ZHelGqWbceaKzrPw/CYFaZiWbn6VZOgWZHQiuSUaCdrs6VKs1eyJZbKxvUyApz3FYV15ujXwWFyUIyAavT6LLDuaC4KIOxPSsCeR5JD5j7yOM11YeCe0rrsc1eTW8bMsanfG+mV+QAuMVd0i/jsrdgsTSSMecDoKi0bSjev5kmREp/OunhtIIV2xxqB9KVerThH2Vrjo06kn7S5nJ4ggMgV0ZB6mtC3vYLn/VSAn0ps9hbzxlGjAz3FcxqMDaXe/uHwCMisIU6VbSOjN5zqUtZao7GkJAGScCs+wv1bTFuJ3AwOc1i6lrEt6RFbhlXPbqazhh5zk49i514xin3NLW7S6udrwN8iDOBUmhpdiEtcscH7oNS6Qt0LVTcnqOBV+idRqPstNAhTTl7QWiiiuc3CiiigAooooAKKKKAGsSFO0ZPasO+0/UL6XLyBU7KO1b1FaU6jpu6M501NWZTsNPhsogqKC3dj1NW6WiplJyd2XGKirIgu7ZLqExyDIPSuVu9JubSTcq7lByCK7GkIBGCM1rRxEqW2xjVoRqb7mFY67GkIjush14qw+v2g+7uarb6baSMWaIZNKunWqDAhWrc6Dd7MSjWStdHParrMl0nlRqY0/U1X0rTmv5+ciNeSa17/QjcSvKj4J6LWnYWq2lqkQAyByfU1u8RCFK1PcwVCc6l6mxLDEkMSxxgBQMVJRSE4GTXnbnfsR3M6W0LSyEAKPzrir+7a8umlbgHoPSrmuagbu48uMny04+pqja2kt3N5USnPf2r1sNRVKPPLc8vEVXUlyR2Hxm4u1jt4wSq9AK6TSdISzXfJh5SPyqzp1hHYwBVAL/AMTVbJCgk9BXLXxLn7sNEdVHD8vvS3Ed1jUs7BQO5rFu/EUcchSBN4HVqyNTv5by6ZVYhM4VRWvpmhRrEstyNznnb6VSowpR5qv3EOtOrLlp/eUzqmpXbfuEKj2FH2zVLMkyKWzzXTJGiDCKFHsKGRXGGAI96j6xDZQVi/YS35ncyNP12OdhHONjmtgciub8QWUdsUuIRtJPSln10pZRxQ8ylfmb0qpUFUSlSW4o1nTbjU6Gvf6lDZR5Yhn7KKpabql1fXBAiAjzyfSszTtLn1CTzZywjzyT1NdRbwR28YjiUKopVI0qUeXeQ6bqVXzbIlooorjOoKKKKACiiigAooooAKKKKACiiigAqOZDJC6A4LDGakooTsG5zA0GZL1Od0eclq6GG2igJMaAFupqaitqledTcyp0Y09gprKGUqehGKdRWJqcbfWklhe79vybsg11NndxXUKtGwJxyKkngjuIykigg1ivoc8Em60mIHpXY6ka8UpuzRyKEqMm4q6Zv0h461hm+1OLKmEHb/FWXc6xeSFlMmAeCBUwwk5PRoqWJjHoyx4ivknmWGPkJ1PvTNG0k3biaUERKenrTNJ0t72XfKCIh39a6yONYowiDCgYAroq1VRh7KG5hSpOrL2k9hVUIoVRgDtTqKK809AKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKAI54VniaNs4b0rJi8PQJMWdiy9loorWFScE1Fmc6cZNNo2ERY0CoAFHQCnUUVkaBRRRQAUUUUAf/Z"
}
```
`HTTP Status: 200 OK.`

You can render the image in an HTML `<img>` tag like this:

```html
<img alt="Captcha" id="5ff6735a-ba78-4c97-8c8d-76b44ff06f3e" src="data:image/jpeg;base64,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FHsKGRXGGAI96j6xDZQVi/YS35ncyNP12OdhHONjmtgciub8QWUdsUuIRtJPSln10pZRxQ8ylfmb0qpUFUSlSW4o1nTbjU6Gvf6lDZR5Yhn7KKpabql1fXBAiAjzyfSszTtLn1CTzZywjzyT1NdRbwR28YjiUKopVI0qUeXeQ6bqVXzbIlooorjOoKKKKACiiigAooooAKKKKACiiigAqOZDJC6A4LDGakooTsG5zA0GZL1Od0eclq6GG2igJMaAFupqaitqledTcyp0Y09gprKGUqehGKdRWJqcbfWklhe79vybsg11NndxXUKtGwJxyKkngjuIykigg1ivoc8Em60mIHpXY6ka8UpuzRyKEqMm4q6Zv0h461hm+1OLKmEHb/FWXc6xeSFlMmAeCBUwwk5PRoqWJjHoyx4ivknmWGPkJ1PvTNG0k3biaUERKenrTNJ0t72XfKCIh39a6yONYowiDCgYAroq1VRh7KG5hSpOrL2k9hVUIoVRgDtTqKK809AKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKAI54VniaNs4b0rJi8PQJMWdiy9loorWFScE1Fmc6cZNNo2ERY0CoAFHQCnUUVkaBRRRQAUUUUAf/Z"
```

<img alt="Captcha" title="#logo" src="/src/main/resources/samples/sample-captcha-3.jpeg">

### POST: Access to a captcha protected endpoint

```
localhost:8080/protected?captchaId=5ff6735a-ba78-4c97-8c8d-76b44ff06f3e&captcha=ditem&username=andre
```

Parameters

| Name        | Type   | Description                                            |
|-------------|--------|--------------------------------------------------------|
| `captchaId` | string | (Required) The id of the captcha obtained.             |
| `captcha`   | string | (Required) The solved captcha.                         |
| `username`  | string | (Required) A username to be displayed in the response. |

If the solved captcha matches the value in the server, it will return a greeting for the provided `username`:
```
Hello andre
```
`HTTP Status: 200 OK.`

Otherwise, the server will return an error response of:

```
Wrong captcha
```
`HTTP Status: 400 Bad Request.`

<a id="improvements"></a>
## Possible Improvements

A system is never perfect and there is always room for improvement. Here are some points that I would like to enhance if I had more time:

- Add Redis as cache;
- Add more customization to the generated captcha;

## Support

* If you have any query or doubt, please, feel free to contact me by e-mail.