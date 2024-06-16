import { Router } from "express";
import { getUserById, } from "../controllers/user-controllers.js";
const userRoutes = Router();
userRoutes.get("/:id", getUserById);
// userRoutes.post("/signup", validate(signupValidator), userSignup);
// userRoutes.post("/login", validate(loginValidator), userLogin);
// userRoutes.get("/auth-status", verifyToken, verifyUser);
// userRoutes.get("/logout", verifyToken, userLogout);
export default userRoutes;
//# sourceMappingURL=user-routes.js.map