class Forum {
    _users
    _qestions
    _id
    constructor() {
        this._users = [];
        this._qestions = [];
        this._id = 1
    }

    register(username, password, repeatPassword, email) {
        if (username === "" || password === "" || repeatPassword === "" || email === "") {
            throw new Error("Input can not be empty")

        }
        if (password !== repeatPassword) {
            throw new Error("Passwords do not match")
        }
        if (this._users.find(s => s.username === username) || this._users.find(e => e.email === email)) {
            throw new Error("This user already exists!")

        }

        let obj = {
            username,
            password,
            email,
            logged: false,

        }
        this._users.push(obj)
        return `${username} with ${email} was registered successfully!`

    }

    login(username, password) {
        if (!this._users.find(s => s.username === username)) {
            throw new Error("There is no such user")
        }
        let user = this._users.find(s => s.username === username)
        if (user.password === password) {
            user.logged = true;
            return "Hello! You have logged in successfully"

        }


    }
    logout(username, password) {
        if (!this._users.find(s => s.username === username)) {
            throw new Error("There is no such user")
        }
        let user = this._users.find(s => s.username === username)
        if (user.password === password) {
            user.logged = false;
            return "You have logged out successfully"


        }

    }


    postQuestion(username, question) {
        let user = this._users.find(s => s.username === username)

        if (!user || !user.logged) {
            throw new Error("You should be logged in to post questions")
        }
        if (question === "") {
            throw new Error("Invalid question")
        }

        let questionObj = {
            id: this._id,
            question: question,
            answer: [],
            postByusername: username,


        }
        this._id++;

        this._qestions.push(questionObj)

        return "Your question has been posted successfully"

    }

    postAnswer(username, questionId, answer) {
        let user = this._users.find(s => s.username === username)

        if (!user || !user.logged) {
            throw new Error("You should be logged in to post questions")
        }
        if (answer === "") {
            throw new Error("Invalid answer")
        }
        let question = this._qestions.find(e => e.id === questionId)

        if (!question) {
            throw new Error("There is no such question")
        }

        let answeredBy = {
            username: username,
            answer: answer
        }

        question.answer.push(answeredBy)

        return "Your answer has been posted successfully"

    }


    showQuestions() {






        return this._qestions.map(q => {
            const answers = q.answer.map(a => `---${a.username}: ${a.answer}`).join("\n")

            return `Question ${q.id} by ${q.postByusername}: ${q.question}\n${answers}`
        }).join("\n")




    }


}

let forum = new Forum();

forum.register('Michael', '123', '123', 'michael@abv.bg');
forum.register('Stoyan', '123ab7', '123ab7', 'some@gmail@.com');
forum.login('Michael', '123');
forum.login('Stoyan', '123ab7');

forum.postQuestion('Michael', "Can I rent a snowboard from your shop?");
forum.postAnswer('Stoyan',1, "Yes, I have rented one last year.");
forum.postQuestion('Stoyan', "How long are supposed to be the ski for my daughter?");
forum.postAnswer('Michael',2, "How old is she?");
forum.postAnswer('Michael',2, "Tell us how tall she is.");

console.log(forum.showQuestions());






