
import "https://unpkg.com/navigo"  //Will create the global Navigo object used below
import {
    renderText, adjustForMissingHash, loadTemplate, renderTemplate, setActiveLink,
} from "/templates/utils.js"

window.addEventListener("load", async () => {
    const templateHome = await loadTemplate("/templates/home.html")
    const templateKandidater = await loadTemplate("/templates/kandidater.html")
    const router = new Navigo("/", { hash: true });
    adjustForMissingHash()
    router
        .hooks({
            before(done, match) { // why dafuq is this unused??
                setActiveLink("topnav", match.url)
                done()
            }
        })
        .on({
            "/": () => renderTemplate(templateHome, "content"),
            "/kandidater": () => renderTemplate(templateKandidater, "content")
        })
        .notFound(() => renderText("No page for this route found", "content"))
        .resolve()
});

//window.onerror = (e) => alert(e)
