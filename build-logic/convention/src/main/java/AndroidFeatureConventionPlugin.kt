import com.jbarrientos.epicjb.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("epicjb.android.library")
                apply("epicjb.android.hilt")
            }


            dependencies {

                add("implementation", project(":core:ui"))

                add("testImplementation", kotlin("test"))
                add("androidTestImplementation", kotlin("test"))

                add("implementation", libs.findLibrary("hilt.navigation.compose").get())
                add("implementation", libs.findLibrary("lifecycle.runtimeCompose").get())
                add("implementation", libs.findLibrary("lifecycle.viewModelCompose").get())
            }
        }
    }
}
