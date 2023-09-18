package io.kusionstack.kcl

import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.platform.lsp.api.ProjectWideLspServerDescriptor

class KCLLspServerDescriptor(project: Project) : ProjectWideLspServerDescriptor(project, "KCL") {
    override fun isSupportedFile(file: VirtualFile): Boolean {
        return file != null && file.fileType is KCLFileType
    }

    override fun createCommandLine(): GeneralCommandLine {
        return GeneralCommandLine("kcl-language-server", "--stdio")
    }

    // references resolution is implemented without using the LSP server
    override val lspGoToDefinitionSupport = false

    // code completion is implemented without using the LSP server
    override val lspCompletionSupport = null
}
